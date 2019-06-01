package com.rlebron.carrental.mapper

import com.rlebron.carrental.dto.ClientDto
import com.rlebron.carrental.model.ClientEntity
import org.springframework.data.domain.Page

class ClientMapperImpl: Mapper<ClientEntity, ClientDto> {
    override fun entityToDto(ent: ClientEntity): ClientDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun entityToDtoList(entList: Page<ClientEntity>): Page<ClientDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dtoToEntity(dto: ClientDto): ClientEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}