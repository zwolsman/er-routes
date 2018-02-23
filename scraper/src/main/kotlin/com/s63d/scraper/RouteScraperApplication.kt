package com.s63d.scraper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RouteScraperApplication
{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<RouteScraperApplication>(*args)
        }
    }
}