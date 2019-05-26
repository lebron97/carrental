package com.rlebron.carrental.mapper

import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.model.CarEntity
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component

@Component
class CarMapperImpl : Mapper<CarEntity, CarDto> {

    override fun entityToDto(ent: CarEntity): CarDto = CarDto(ent.carPlate, ent.make, ent.model)

    override fun dtoToEntity(dto: CarDto): CarEntity = CarEntity(dto.carPlate, dto.make, dto.model, null, null)
}