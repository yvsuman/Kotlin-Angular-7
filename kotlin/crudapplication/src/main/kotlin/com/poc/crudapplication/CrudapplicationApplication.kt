package com.poc.crudapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class CrudapplicationApplication

fun main(args: Array<String>) {
	runApplication<CrudapplicationApplication>(*args)
}

