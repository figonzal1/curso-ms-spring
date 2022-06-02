package cl.figonzal.motoms.service

import cl.figonzal.motoms.entity.Moto
import cl.figonzal.motoms.repository.MotoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MotoService {

    @Autowired
    private lateinit var motoRepository: MotoRepository

    fun getAll(): List<Moto> {
        return motoRepository.findAll().toList()
    }

    fun getMotoById(id: Int): Moto? {
        return motoRepository.findById(id).orElse(null)
    }

    fun saveMoto(moto: Moto): Moto {
        return motoRepository.save(moto)
    }

    fun getMotosByUser(userId: Int): List<Moto> {
        return motoRepository.findMotosByUserId(userId)
    }
}