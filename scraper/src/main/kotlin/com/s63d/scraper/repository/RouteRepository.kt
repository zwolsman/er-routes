package com.s63d.scraper.repository

import com.s63d.scraper.domain.database.RoutesItem
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface RouteRepository : MongoRepository<RoutesItem, ObjectId>