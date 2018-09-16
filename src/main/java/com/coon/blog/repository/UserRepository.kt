package com.coon.blog.repository

import com.coon.blog.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,String> {
    fun findByUsername(username: String): User?
}