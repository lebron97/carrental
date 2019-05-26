package com.rlebron.carrental.service

import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.model.CarEntity

interface CarService {

    fun findAll() : List<CarDto>

    fun create(car : CarEntity) : CarEntity
}