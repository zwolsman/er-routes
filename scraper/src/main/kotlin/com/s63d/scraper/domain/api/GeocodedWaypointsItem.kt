package com.s63d.scraper.domain.api

data class GeocodedWaypointsItem(val types: List<String>?,
                                 val geocoderStatus: String = "",
                                 val placeId: String = "")