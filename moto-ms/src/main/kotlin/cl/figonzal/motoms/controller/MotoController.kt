package cl.figonzal.motoms.controller

import cl.figonzal.motoms.entity.Moto
import cl.figonzal.motoms.service.MotoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/moto")
class MotoController {

    @Autowired
    private lateinit var motoService: MotoService

    @GetMapping
    fun getMotoList(): ResponseEntity<List<Moto>> {

        with(motoService.getAll()) {

            if (isEmpty()) {
                return ResponseEntity.noContent().build()
            }
            return ResponseEntity.ok(this)
        }
    }

    @GetMapping("/{id}")
    fun getMoto(@PathVariable("id") id: Int): ResponseEntity<Moto> {

        val user = motoService.getMotoById(id) ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun saveMoto(@RequestBody Moto: Moto): ResponseEntity<Moto> {
        return ResponseEntity.ok(motoService.saveMoto(Moto))
    }

    @GetMapping("/user/{userId}")
    fun getUserMotos(@PathVariable userId: Int): ResponseEntity<List<Moto>> {

        with(motoService.getMotosByUser(userId)) {

            if (isEmpty()) {
                return ResponseEntity.noContent().build()
            }
            return ResponseEntity.ok(this)
        }
    }
}