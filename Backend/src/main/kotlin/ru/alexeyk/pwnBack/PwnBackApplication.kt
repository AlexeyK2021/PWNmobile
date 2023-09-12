package ru.alexeyk.pwnBack

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PwnBackApplication

fun main(args: Array<String>) {
	runApplication<PwnBackApplication>(*args)
}
