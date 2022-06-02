package cl.figonzal.carms.repository

import cl.figonzal.carms.entity.Car
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository : JpaRepository<Car, Int> {

    fun findCarsByUserId(userId: Int): List<Car>
}