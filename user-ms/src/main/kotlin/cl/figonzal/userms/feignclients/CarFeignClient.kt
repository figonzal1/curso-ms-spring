package cl.figonzal.userms.feignclients

import cl.figonzal.userms.model.Car
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "car-ms", url = "http://localhost:8082", path = "/car")
interface CarFeignClient {

    @PostMapping
    fun saveUserCar(@RequestBody car: Car): Car

    // url, ex: /car/user/1
    @GetMapping("/user/{userId}")
    fun getUserCars(@PathVariable userId: Int): List<Car>
}