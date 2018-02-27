package com.s63d.simulator

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.s63d.simulator.domain.database.RoutesItem
import com.s63d.simulator.repository.RouteRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.data.geo.Point
import org.springframework.stereotype.Component
import java.util.*

@Component
class Simulator(val routeRepository: RouteRepository) : CommandLineRunner {
    private val logger = LoggerFactory.getLogger(this::class.java)
    val url = "http://localhost:8080/api/location"
    val interval = 30
    val sleepTime:Long = 1 * 1000
    val threads = 250
    override fun run(vararg args: String?) {
        logger.info("Loading routes..")
        val routes = routeRepository.findAll()
        logger.info("Finished loading ${routes.size} routes")
        logger.info("Starting ${threads} threads")

        for(i in 0..threads) {
            Thread(SimulatorRunnable(routes.random(), i)).start()
            Thread.sleep(Random().nextInt(5000).toLong())
        }
    }
    fun <E> List<E>.random(): E = if (size == 0) throw UnsupportedOperationException() else get(Random().nextInt(size))



    inner class SimulatorRunnable(val route:RoutesItem, val id:Int) : Runnable {
        private val logger = LoggerFactory.getLogger(this::class.java)

        override fun run() {
            val steps = route.legs[0].steps
            logger.info("Starting route, duration: ${route.legs[0].duration.text}, distance: ${route.legs[0].distance.text}")
            var distanceLeft = 0.0
            var currentLocation = steps[0].polyline.coordinates[0]
            for (step in steps) {
                val speed = step.distance.value / step.duration.value
                val actualMeters = speed * interval //aantal meter gereden in de interval
                val destinations = mutableListOf<Point>()
                destinations.addAll(step.polyline.coordinates.filterNot { it == currentLocation })

                val pointHistory = mutableListOf<Point>()
                //println("starting new step.. there were $distanceLeft m driven from prev one")
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
                        pointHistory.clear()
                        distanceLeft = actualMeters.toDouble()
                    }
                    //println("I am at $currentLocation")

                    val req = Fuel.post(url, listOf("x" to currentLocation.x, "y" to currentLocation.y, "id" to id))
                    req.response { request, response, result ->
                        if (result is Result.Failure) {
                            println(result.error)

                        }
                    }
                    Thread.sleep(sleepTime)
                }
            }
            logger.info("Finished route")
            //print("done")
            //println()
        }

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

