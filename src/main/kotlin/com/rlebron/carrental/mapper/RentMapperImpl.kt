package com.rlebron.carrental.mapper

import com.rlebron.carrental.dto.RentDto
import com.rlebron.carrental.model.RentEntity

class RentMapperImpl: Mapper<RentEntity, RentDto> {
    override fun entityToDto(ent: RentEntity): RentDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun entityToDtoList(entList: List<RentEntity>): List<RentDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dtoToEntity(dto: RentDto): RentEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}