package com.rlebron.carrental.mapper

import com.rlebron.carrental.dto.RateDto
import com.rlebron.carrental.model.RateEntity
import org.springframework.data.domain.Page

class RateMapperImpl: Mapper<RateEntity, RateDto> {
    override fun entityToDto(ent: RateEntity): RateDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun entityToDtoList(entList: Page<RateEntity>): Page<RateDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dtoToEntity(dto: RateDto): RateEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}