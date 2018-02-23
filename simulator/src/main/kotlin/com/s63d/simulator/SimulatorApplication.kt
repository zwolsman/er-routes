package com.s63d.simulator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class SimulatorApplication
{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SimulatorApplication>(*args)
        }
    }
}
