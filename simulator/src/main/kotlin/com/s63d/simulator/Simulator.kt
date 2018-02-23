package com.s63d.simulator

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.s63d.simulator.repository.RouteRepository
import org.bson.types.ObjectId
import org.springframework.boot.CommandLineRunner
import org.springframework.data.geo.Point
import org.springframework.stereotype.Component

@Component
class Simulator(val routeRepository: RouteRepository) : CommandLineRunner {

    val routeId = ObjectId("5a8c949fad980930f7b59246")
    val interval = 30
    val sleepTime:Long = 1 * 1000

    override fun run(vararg args: String?) {
        val route = routeRepository.findById(routeId).get()
        val steps = route.legs[0].steps

        var distanceLeft = 0.0
        var currentLocation = steps[0].polyline.coordinates[0]
        for (step in steps) {
            val speed = step.distance.value / step.duration.value
            val actualMeters = speed * interval //aantal meter gereden in de interval

            println("the step is ${step.distance.value}m long, it will take ${step.duration.value}s")
            println("I will cruise with a speed of ${step.distance.value / step.duration.value} m/s")
            println("This means I am allowed to drive $actualMeters m")
            println("There are ${step.polyline.coordinates.size} points for this step")
            println()




            val destinations = mutableListOf<Point>()
            destinations.addAll(step.polyline.coordinates.filterNot { it == currentLocation })

            val pointHistory = mutableListOf<Point>()
            println("starting new step.. there were $distanceLeft m driven from prev one")
            distanceLeft = actualMeters.toDouble() - distanceLeft
            while (destinations.isNotEmpty()) {
                pointHistory.add(currentLocation)
                val destination = destinations[0]

                val distanceInMeters = distance(currentLocation, destination)

                if (distanceLeft < distanceInMeters) {
                    val direction = destination - currentLocation
                    val normalized = direction / distanceInMeters.toFloat()
                    val actualDistance = normalized * distanceLeft.toFloat()
                    val actualPoint = actualDistance + currentLocation

                    currentLocation = actualPoint
                    distanceLeft = 0.0
                    pointHistory.add(currentLocation)
                } else {
                    currentLocation = destination
                    distanceLeft -= distanceInMeters
                    destinations.removeAt(0)
                }



                if (distanceLeft == 0.0) {
                    //println("Oke ik heb ${actualMeters}m gereden. dit zijn de punten waar ik ben geweest:")

                    var previous = pointHistory[0]
                    pointHistory.stream().skip(1).forEach {
                        //println("Driving from $previous to $it which is ${distance(previous, it)}m")
                        previous = it
                    }
                    //println()
                    pointHistory.clear()
                    distanceLeft = actualMeters.toDouble()
                }
                println("I am at $currentLocation")

                val req = Fuel.post("http://localhost:8080/api/location", listOf("x" to currentLocation.x, "y" to currentLocation.y))
               // println(req)
                req.response { request, response, result ->
                    if (result is Result.Failure) {
                        println("Whoops")
                        println(result.error)

                    } else {
                        print("Sent!")
                    }
                }
                Thread.sleep(sleepTime)
            }
        }
//
//        println("Ik heb alle destinations gehad! Dit is wat ik als laatste heb afgelegd")
//        var previous = pointHistory[0]
//        pointHistory.stream().skip(1).forEach {
//            println("Driving from $previous to $it which is ${distance(previous, it)}m")
//            previous = it
//        }
        print("done")
        println()
    }




    operator fun Point.plus(v: Float) = Point(x + v, y + v)
    operator fun Point.minus(v: Float) = Point(x - v, y - v)
    operator fun Point.times(v: Float) = Point(x * v, y * v)
    operator fun Point.div(v: Float) = Point(x / v, y / v)

    operator fun Point.plus(v: Point) = Point(x + v.x, y + v.y)
    operator fun Point.minus(v: Point) = Point(x - v.x, y - v.y)
    operator fun Point.times(v: Point) = Point(x * v.x, y * v.y)
    operator fun Point.div(v: Point) = Point(x / v.x, y / v.y)
}

