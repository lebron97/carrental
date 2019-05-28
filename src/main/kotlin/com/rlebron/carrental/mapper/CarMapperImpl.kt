package com.rlebron.carrental.mapper

import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.model.CarEntity
import org.springframework.stereotype.Component

@Component
class CarMapperImpl : Mapper<CarEntity, CarDto> {

    //fun CarEntity.toCarDto() = CarDto(idCar, carPlate = carPlate, registrationYear = registrationYear)

    override fun entityToDto(ent: CarEntity): CarDto{
        /*val modelMapper = ModelMapper()
        return modelMapper.map(ent, CarDto::class.java)*/
        return CarDto(ent.idCar, ent.carPlate, ent.registrationYear)
    }

    override fun dtoToEntity(dto: CarDto): CarEntity{
        /*val modelMapper = ModelMapper()
        return modelMapper.map(dto, CarEntity::class.java)*/
        return CarEntity(dto.id, dto.carPlate, dto.registrationYear)
    }
}