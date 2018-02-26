package com.s63d.registrationsystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RegistrationSystemApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<RegistrationSystemApplication>(*args)
        }
    }
}