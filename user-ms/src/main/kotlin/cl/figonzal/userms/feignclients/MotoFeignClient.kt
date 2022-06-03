package cl.figonzal.userms.feignclients

import cl.figonzal.userms.model.Moto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "moto-ms", path = "/moto")
interface MotoFeignClient {

    @PostMapping
    fun save(@RequestBody moto: Moto): Moto

}