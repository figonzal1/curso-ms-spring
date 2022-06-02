package cl.figonzal.userms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class UserMsApplication

fun main(args: Array<String>) {
    runApplication<UserMsApplication>(*args)
}
