package cl.figonzal.motoms.repository

import cl.figonzal.motoms.entity.Moto
import org.springframework.data.jpa.repository.JpaRepository

interface MotoRepository : JpaRepository<Moto, Int> {

    fun findMotosByUserId(userId: Int): List<Moto>
}