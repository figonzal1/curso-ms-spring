package cl.figonzal.carms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarMsApplication

fun main(args: Array<String>) {
    runApplication<CarMsApplication>(*args)
}
