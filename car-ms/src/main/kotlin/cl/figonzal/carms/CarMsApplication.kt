package cl.figonzal.carms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class CarMsApplication

fun main(args: Array<String>) {
    runApplication<CarMsApplication>(*args)
}
