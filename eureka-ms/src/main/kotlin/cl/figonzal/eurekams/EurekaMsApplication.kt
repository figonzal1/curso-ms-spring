package cl.figonzal.eurekams

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EurekaMsApplication

fun main(args: Array<String>) {
    runApplication<EurekaMsApplication>(*args)
}
