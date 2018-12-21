package com.poc.crudapplication.repository

import com.poc.crudapplication.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsarioRepository: JpaRepository<Users, Long>