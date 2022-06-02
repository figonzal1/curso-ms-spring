package cl.figonzal.userms.repository

import cl.figonzal.userms.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int>