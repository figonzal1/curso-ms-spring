package cl.figonzal.carms.service

import cl.figonzal.carms.entity.Car
import cl.figonzal.carms.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarService {

    @Autowired
    private lateinit var carRepository: CarRepository

    fun getAll(): List<Car> {
        return carRepository.findAll().toList()
    }

    fun getCarById(id: Int): Car? {
        return carRepository.findById(id).orElse(null)
    }

    fun saveUser(car: Car): Car {
        return carRepository.save(car)
    }

    fun getCarsByUser(userId: Int): List<Car> {
        return carRepository.findCarsByUserId(userId)
    }
}