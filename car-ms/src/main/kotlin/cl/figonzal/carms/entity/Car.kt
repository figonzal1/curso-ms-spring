package cl.figonzal.carms.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    lateinit var brand: String
    lateinit var model: String
    var userId: Int = 0


    override fun toString(): String {
        return "Car(id=$id, brand='$brand', model='$model', userId=$userId)"
    }
}