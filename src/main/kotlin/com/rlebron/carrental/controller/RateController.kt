package com.rlebron.carrental.controller

import com.rlebron.carrental.dto.RateDto
import com.rlebron.carrental.mapper.RateMapper
import com.rlebron.carrental.model.RateEntity
import com.rlebron.carrental.service.RateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/rate")
class RateController @Autowired constructor(val rateService: RateService, val mapper: RateMapper<RateEntity, RateDto>) {

    @PostMapping
    fun post(@Valid @RequestBody rateDto: RateDto): RateDto = rateDto.let(mapper::dtoToEntity).let(rateService::create).let(mapper::entityToDto)

}