package com.rlebron.carrental.mapper

import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.model.CarEntity
import org.springframework.stereotype.Component

@Component
class CarMapperImpl : Mapper<CarEntity, CarDto> {

    override fun entityToDto(ent: CarEntity): CarDto = CarDto(ent.idCar, ent.carPlate, ent.registrationYear)
    override fun dtoToEntity(dto: CarDto): CarEntity = CarEntity(dto.id, dto.carPlate, dto.registrationYear)

    override fun entityToDtoList(entList: List<CarEntity>): List<CarDto> {

        val carsDto : MutableList<CarDto> = ArrayList()

        entList.forEach { carsDto.add(CarDto(it.idCar, it.carPlate, it.registrationYear)) }

        return carsDto
    }

}