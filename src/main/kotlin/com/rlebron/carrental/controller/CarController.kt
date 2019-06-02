package com.rlebron.carrental.controller

import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.mapper.Mapper
import com.rlebron.carrental.model.CarEntity
import com.rlebron.carrental.service.GenericService
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
@RequestMapping("/car")
class CarController @Autowired constructor(val carService: GenericService<CarEntity>, val mapper: Mapper<CarEntity, CarDto>) {

    //Tengo dudas sobre let{}, let() y map. De cuando puedo usar cada uno. Y con el hecho de que el repositorio usado
    //devuelva Optionals de java en vez de ?.

    @GetMapping
    fun getAll(): Page<CarDto> = carService.findAll(PageRequest.of(0, 10)).let(mapper::entityToDtoList)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") idCar: Int): ResponseEntity<CarDto> =
            try {
                ResponseEntity(
                        carService.findById(idCar).map(mapper::entityToDto).orElseThrow { NotFoundException("Car not found") },
                        HttpStatus.OK)
            } catch (e: NotFoundException) {
                ResponseEntity(
                        HttpStatus.NOT_FOUND)
            }

    @PostMapping
    fun post(@Valid @RequestBody carDto: CarDto): CarDto = carDto.let(mapper::dtoToEntity).let(carService::create).let(mapper::entityToDto)

    @PutMapping("/{id}")
    fun put(@PathVariable("id") id: Int, @RequestBody carDto: CarDto): ResponseEntity<CarDto> =
            Optional.ofNullable(carDto)
                    .map(mapper::dtoToEntity)
                    .flatMap { e -> carService.update(id, e) }
                    .map(mapper::entityToDto)
                    .map { e -> ResponseEntity(e, HttpStatus.OK) }
                    .orElse(ResponseEntity(HttpStatus.NOT_FOUND))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idCar: Int): ResponseEntity<Any> =
            try {
                carService.delete(idCar).let { ResponseEntity(HttpStatus.OK) }
            } catch (e: EmptyResultDataAccessException) {
                ResponseEntity(HttpStatus.NOT_FOUND)
            }

}