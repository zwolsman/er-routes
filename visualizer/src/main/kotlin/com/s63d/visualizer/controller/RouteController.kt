package com.s63d.visualizer.controller

import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RouteController(val messaging: SimpMessagingTemplate) {
    data class LocationBody(val coordinates: List<Double>?)

    @PostMapping("/location")
    fun newLocation(x:Double, y:Double) {
        val coords = listOf(y,x)
        println(coords)

        messaging.convertAndSend("/location", coords)
    }
}

