package cl.figonzal.carms.controller

import cl.figonzal.carms.entity.Car
import cl.figonzal.carms.service.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/car")
class CarController {

    @Autowired
    private lateinit var carService: CarService

    @GetMapping
    fun getCarList(): ResponseEntity<List<Car>> {

        with(carService.getAll()) {

            if (isEmpty()) {
                return ResponseEntity.noContent().build()
            }
            return ResponseEntity.ok(this)
        }
    }

    @GetMapping("/{id}")
    fun getCar(@PathVariable("id") id: Int): ResponseEntity<Car> {

        val user = carService.getCarById(id) ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun saveCar(@RequestBody car: Car): ResponseEntity<Car> {
        return ResponseEntity.ok(carService.saveUser(car))
    }

    @GetMapping("/user/{userId}")
    fun getUserCars(@PathVariable userId: Int): ResponseEntity<List<Car>> {

        with(carService.getCarsByUser(userId)) {

            if (isEmpty()) {
                return ResponseEntity.noContent().build()
            }
            return ResponseEntity.ok(this)
        }
    }
}