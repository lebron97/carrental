package com.rlebron.carrental.mapper

import com.rlebron.carrental.dto.ClientDto
import com.rlebron.carrental.model.ClientEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component

@Component
class ClientMapperImpl: Mapper<ClientEntity, ClientDto> {

    override fun entityToDto(ent: ClientEntity): ClientDto = ClientDto(ent.idClient, ent.dni, ent.name)

    override fun entityToDtoList(entList: Page<ClientEntity>): Page<ClientDto>{
        val clientsDto : MutableList<ClientDto> = ArrayList()
        entList.forEach { clientsDto.add(ClientDto(it.idClient, it.dni, it.name)) }
        val clientsDtoP : Page<ClientDto>  = PageImpl(clientsDto)

        return clientsDtoP
    }

    override fun dtoToEntity(dto: ClientDto): ClientEntity  = ClientEntity(dto.id, dto.dni, dto.name)

}