package com.example.spring.using.Kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringUsingKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringUsingKotlinApplication>(*args)
}
