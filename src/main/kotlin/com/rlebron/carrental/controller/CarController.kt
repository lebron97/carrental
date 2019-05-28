package com.rlebron.carrental.controller

import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.service.CarService
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus


@RestController
@RequestMapping("/car")
class CarController @Autowired constructor(val carService: CarService) {

    @GetMapping
    fun getAll(): List<CarDto> = carService.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") idCar: Int): ResponseEntity<CarDto> {

        return try {
            ResponseEntity(
                    carService.findById(idCar),
                    HttpStatus.OK)

        } catch (e: NotFoundException) {
            ResponseEntity(
                    CarDto(),
                    HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping
    fun post(@RequestBody carDto: CarDto): CarDto = carService.create(carDto)

    @PutMapping
    fun put(@RequestBody carDto: CarDto): CarDto{
        return carService.update(carDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id")idCar: Int){
        carService.delete(idCar)
    }

}