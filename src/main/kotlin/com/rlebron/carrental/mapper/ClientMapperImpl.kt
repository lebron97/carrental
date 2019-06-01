package com.rlebron.carrental.mapper

import com.rlebron.carrental.dto.ClientDto
import com.rlebron.carrental.model.ClientEntity

class ClientMapperImpl: Mapper<ClientEntity, ClientDto> {
    override fun entityToDto(ent: ClientEntity): ClientDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun entityToDtoList(entList: List<ClientEntity>): List<ClientDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dtoToEntity(dto: ClientDto): ClientEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}