package cl.figonzal.userms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
class UserMsApplication

fun main(args: Array<String>) {
    runApplication<UserMsApplication>(*args)
}
