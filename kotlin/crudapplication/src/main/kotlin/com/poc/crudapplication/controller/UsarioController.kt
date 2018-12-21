package com.poc.crudapplication.controller

import com.poc.crudapplication.entity.Users
import com.poc.crudapplication.repository.UsarioRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
@CrossOrigin
class UsarioController(private val usarioRepository: UsarioRepository) {

	@GetMapping("/users")
	fun getAllUsers(): List<Users> =
		usarioRepository.findAll()

	@GetMapping("/user/{id}")
	fun getUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<Users> {
		return usarioRepository.findById(userId).map { users ->
			ResponseEntity.ok(users)
		}.orElse(ResponseEntity.notFound().build())
	}

	@PostMapping("/user")
	fun createNewUser(@RequestBody user: Users): Users =
		usarioRepository.save(user)

	@DeleteMapping("/user/{id}")
	fun deleteArticleById(@PathVariable(value = "id") userId: Long): ResponseEntity<Void> {

		return usarioRepository.findById(userId).map { user ->
			usarioRepository.delete(user)
			ResponseEntity<Void>(HttpStatus.OK)
		}.orElse(ResponseEntity.notFound().build())

	}

	@PutMapping("/user/{id}")
	fun updateArticleById(
		@PathVariable(value = "id") userId: Long,
		@Valid @RequestBody newUser: Users
	): ResponseEntity<Users> {

		return usarioRepository.findById(userId).map { updateUser ->
			val updatedUser: Users = updateUser
				.copy(firstname = newUser.firstname, lastname = newUser.lastname, email = newUser.email)

			ResponseEntity.ok().body(usarioRepository.save(updatedUser))
		}.orElse(ResponseEntity.notFound().build())
	}


}