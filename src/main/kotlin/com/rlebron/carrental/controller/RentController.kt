package com.rlebron.carrental.controller

import com.rlebron.carrental.dto.RentDto
import com.rlebron.carrental.mapper.Mapper
import com.rlebron.carrental.model.RentEntity
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
@RequestMapping("/rental")
class RentController @Autowired constructor(val rentService: GenericService<RentEntity>, val mapper: Mapper<RentEntity, RentDto>){

    @GetMapping
    fun getAll(): Page<RentDto> = rentService.findAll(PageRequest.of(0, 10)).let(mapper::entityToDtoList)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") idRent: Int): ResponseEntity<RentDto> =
            try {
                ResponseEntity(
                        rentService.findById(idRent).map(mapper::entityToDto).orElseThrow { NotFoundException("Rent not found") },
                        HttpStatus.OK)
            } catch (e: NotFoundException) {
                ResponseEntity(
                        HttpStatus.NOT_FOUND)
            }

    @PostMapping
    fun post(@Valid @RequestBody rentDto: RentDto): RentDto = rentDto.let(mapper::dtoToEntity).let(rentService::create).let(mapper::entityToDto)

    @PutMapping("/{id}")
    fun put(@PathVariable("id") id: Int, @RequestBody rentDto: RentDto): ResponseEntity<RentDto> =
            Optional.ofNullable(rentDto)
                    .map(mapper::dtoToEntity)
                    .flatMap { e -> rentService.update(id, e) }
                    .map(mapper::entityToDto)
                    .map { e -> ResponseEntity(e, HttpStatus.OK) }
                    .orElse(ResponseEntity(HttpStatus.NOT_FOUND))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idRent: Int): ResponseEntity<Any> =
            try {
                rentService.delete(idRent).let { ResponseEntity(HttpStatus.OK) }
            } catch (e: EmptyResultDataAccessException) {
                ResponseEntity(HttpStatus.NOT_FOUND)
            }
    


}