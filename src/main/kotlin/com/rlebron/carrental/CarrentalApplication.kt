package com.rlebron.carrental

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Profile

@SpringBootApplication

class CarrentalApplication

fun main(args: Array<String>) {
	runApplication<CarrentalApplication>(*args)
}
