package com.poc.crudapplication.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.persistence.GenerationType

@Entity
data class Users(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(
    name = "native",
    strategy = "native"
    )
	@Column(name = "ID")
	val id: Long = 0,

	@get: NotBlank
	@Column(name = "FIRSTNAME")
	val firstname: String = "",

	@get: NotBlank
	@Column(name = "LASTNAME")
	val lastname: String = "",

	@get: NotBlank
	@Column(name = "EMAIL")
	val email: String = ""

) 