package com.s63d.scraper.domain.api

data class MapsResponse(val routes: List<RoutesItem>,
                        val geocodedWaypoints: List<GeocodedWaypointsItem>?,
                        val status: String = "")