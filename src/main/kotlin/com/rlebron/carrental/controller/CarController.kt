package com.rlebron.carrental.controller

import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.mapper.CarMapperImpl
import com.rlebron.carrental.mapper.Mapper
import com.rlebron.carrental.service.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/car")
class CarController @Autowired constructor(val carService: CarService, val carMapper : CarMapperImpl) {


    @GetMapping
    fun getAll() : List<CarDto>{
        return carService.findAll()
    }

    @PostMapping
    fun post(@RequestBody carDto: CarDto) : CarDto{
        carService.create(carMapper.dtoToEntity(carDto))
        return carDto
    }
}