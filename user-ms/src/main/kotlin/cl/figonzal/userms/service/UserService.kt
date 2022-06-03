package cl.figonzal.userms.service

import cl.figonzal.userms.entity.User
import cl.figonzal.userms.feignclients.CarFeignClient
import cl.figonzal.userms.feignclients.MotoFeignClient
import cl.figonzal.userms.model.Car
import cl.figonzal.userms.model.Moto
import cl.figonzal.userms.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class UserService {

    @Autowired
    private lateinit var carFeignClient: CarFeignClient

    @Autowired
    private lateinit var motoFeignClient: MotoFeignClient

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Autowired
    private lateinit var userRepository: UserRepository

    fun getAll(): List<User> {
        return userRepository.findAll().toList()
    }

    fun getUserById(id: Int): User? {
        return userRepository.findById(id).orElse(null)
    }

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    //REST TEMPLATE
    fun getCars(userId: Int): List<Car>? {
        return carFeignClient.getUserCars(userId)
    }

    fun getMotos(userId: Int): List<Moto>? {
        //TODO: Reemplazar por la llamada a feign
        return restTemplate.getForObject("http://localhost:8081/moto/user/$userId", Array<Moto>::class.java)?.toList()
    }

    //FEIGN CLIENT

    //guardar auto en microservicio car pero desde microservicio usuario
    fun saveCar(userId: Int, car: Car): Car {
        car.userId = userId
        return carFeignClient.saveUserCar(car)
    }

    //guardar moto en microservicio car pero desde microservicio usuario
    fun saveMoto(userId: Int, moto: Moto): Moto? {
        moto.userId = userId
        return motoFeignClient.save(moto)
    }

    //Obtener datos desde todos los miscroservicios desde user-ms
    fun getUserVehicles(userId: Int): HashMap<String, Any> {

        val result = hashMapOf<String, Any>()

        val user = userRepository.findById(userId).orElse(null)

        if (user == null) {
            result["message"] = "El usuario no existe"
        }

        result["user"] = user

        //solicita datos al car-ms
        val cars = carFeignClient.getUserCars(userId)

        if (cars.isEmpty()) {
            result["message"] = "El usuario no tiene autos"
        }
        result["cars"] = cars

        return result
    }
}