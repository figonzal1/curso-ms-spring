package cl.figonzal.userms.controller

import cl.figonzal.userms.entity.User
import cl.figonzal.userms.model.Car
import cl.figonzal.userms.model.Moto
import cl.figonzal.userms.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUserList(): ResponseEntity<List<User>> {

        with(userService.getAll()) {

            if (isEmpty()) {
                return ResponseEntity.noContent().build()
            }
            return ResponseEntity.ok(this)
        }
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Int): ResponseEntity<User> {

        val user = userService.getUserById(id) ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun saveUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity.ok(userService.saveUser(user))
    }

    @GetMapping("/{userId}/cars")
    fun getUserCars(@PathVariable userId: Int): ResponseEntity<List<Car>> {

        val user = userService.getUserById(userId) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(userService.getCars(user.id))

    }

    @GetMapping("/{userId}/motos")
    fun getUserMotos(@PathVariable userId: Int): ResponseEntity<List<Moto>> {
        val user = userService.getUserById(userId) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(userService.getMotos(user.id))
    }

    //Guardar auto desde user-ms
    @PostMapping("/{userId}/car")
    fun saveCar(@PathVariable userId: Int, @RequestBody car: Car): ResponseEntity<Car> {
        val newCar = userService.saveCar(userId, car)

        return ResponseEntity.ok(newCar)
    }

    //guardar moto desde user-ms
    @PostMapping("/{userId}/moto")
    fun saveMoto(@PathVariable userId: Int, @RequestBody moto: Moto): ResponseEntity<Moto> {
        val newMoto = userService.saveMoto(userId, moto)

        return ResponseEntity.ok(newMoto)
    }

    //consultar todos los vehiculos del usuario
    @GetMapping("/{userId}/vehicles")
    fun getVehicles(@PathVariable userId: Int): ResponseEntity<HashMap<String, Any>> {

        with(userService.getUserVehicles(userId)) {

            if (isEmpty()) {
                return ResponseEntity.noContent().build()
            }
            return ResponseEntity.ok(this)
        }
    }
}