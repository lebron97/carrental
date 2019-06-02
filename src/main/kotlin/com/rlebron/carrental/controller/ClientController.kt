package com.rlebron.carrental.controller

import com.rlebron.carrental.dto.ClientDto
import com.rlebron.carrental.mapper.Mapper
import com.rlebron.carrental.model.ClientEntity
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
@RequestMapping("/client")
class ClientController @Autowired constructor(val clientService: GenericService<ClientEntity>, val mapper: Mapper<ClientEntity, ClientDto>){

    @GetMapping
    fun getAll(): Page<ClientDto> = clientService.findAll(PageRequest.of(0, 10)).let(mapper::entityToDtoList)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") idClient: Int): ResponseEntity<ClientDto> =
            try {
                ResponseEntity(
                        clientService.findById(idClient).map(mapper::entityToDto).orElseThrow { NotFoundException("Client not found") },
                        HttpStatus.OK)
            } catch (e: NotFoundException) {
                ResponseEntity(
                        HttpStatus.NOT_FOUND)
            }

    @PostMapping
    fun post(@Valid @RequestBody clientDto: ClientDto): ClientDto = clientDto.let(mapper::dtoToEntity).let(clientService::create).let(mapper::entityToDto)

    @PutMapping("/{id}")
    fun put(@PathVariable("id") id: Int, @RequestBody clientDto: ClientDto): ResponseEntity<ClientDto> =
            Optional.ofNullable(clientDto)
                    .map(mapper::dtoToEntity)
                    .flatMap { e -> clientService.update(id, e) }
                    .map(mapper::entityToDto)
                    .map { e -> ResponseEntity(e, HttpStatus.OK) }
                    .orElse(ResponseEntity(HttpStatus.NOT_FOUND))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idClient: Int): ResponseEntity<Any> =
            try {
                clientService.delete(idClient).let { ResponseEntity(HttpStatus.OK) }
            } catch (e: EmptyResultDataAccessException) {
                ResponseEntity(HttpStatus.NOT_FOUND)
            }
}