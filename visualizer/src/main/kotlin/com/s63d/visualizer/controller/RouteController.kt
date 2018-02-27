package com.s63d.visualizer.controllercoord

import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RouteController(val messaging: SimpMessagingTemplate) {
    data class LocationUpdate(val coords:List<Double>, val id:Int)
    @PostMapping("/location")
    fun newLocation(x:Double, y:Double, id:Int) {
        val coords = listOf(y,x)
        messaging.convertAndSend("/location", LocationUpdate(coords, id))
    }
}

