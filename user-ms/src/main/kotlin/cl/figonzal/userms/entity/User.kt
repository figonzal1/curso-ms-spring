package cl.figonzal.userms.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    lateinit var name: String

    lateinit var email: String

    override fun toString(): String {
        return "Usuario(id=$id, name='$name', email='$email')"
    }


}