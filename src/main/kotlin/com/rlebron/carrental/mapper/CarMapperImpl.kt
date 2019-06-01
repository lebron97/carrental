package com.rlebron.carrental.mapper

import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.model.CarEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component

@Component
class CarMapperImpl : Mapper<CarEntity, CarDto> {

    override fun entityToDto(ent: CarEntity): CarDto = CarDto(ent.idCar, ent.carPlate, ent.registrationYear)
    override fun dtoToEntity(dto: CarDto): CarEntity = CarEntity(dto.id, dto.carPlate, dto.registrationYear)

    override fun entityToDtoList(entList: Page<CarEntity>): Page<CarDto> {

        val carsDto : MutableList<CarDto> = ArrayList()
        entList.forEach { carsDto.add(CarDto(it.idCar, it.carPlate, it.registrationYear)) }
        val carsDtoP : Page<CarDto>  = PageImpl(carsDto)

        return carsDtoP
    }

}