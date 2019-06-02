package com.rlebron.carrental.mapper.Impl

import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.dto.ClientDto
import com.rlebron.carrental.dto.RentDto
import com.rlebron.carrental.mapper.Mapper
import com.rlebron.carrental.model.CarEntity
import com.rlebron.carrental.model.ClientEntity
import com.rlebron.carrental.model.RentEntity
import com.rlebron.carrental.utils.StringDateFomatter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component

@Component
class RentMapperImpl @Autowired constructor(val carMapper: Mapper<CarEntity, CarDto>, val clientMapper: Mapper<ClientEntity, ClientDto>) : Mapper<RentEntity, RentDto> {

    override fun entityToDto(ent: RentEntity): RentDto = RentDto(ent.idRent, ent.car.let { carMapper.entityToDto(it!!) }, ent.client.let { clientMapper.entityToDto(it!!) }, ent.rentPrice, ent.rentStartDate.toString(), ent.rentExpirationDate.toString())

    override fun entityToDtoList(entList: Page<RentEntity>): Page<RentDto> {
        val rentsDto: MutableList<RentDto> = ArrayList()
        entList.forEach { rentsDto.add(RentDto(it.idRent, it.car.let { c -> carMapper.entityToDto(c!!) }, it.client.let { c -> clientMapper.entityToDto(c!!) }, it.rentPrice, it.rentStartDate.toString(), it.rentExpirationDate.toString())) }
        val rentsDtoP: Page<RentDto> = PageImpl(rentsDto)

        return rentsDtoP
    }

    override fun dtoToEntity(dto: RentDto): RentEntity =
            RentEntity(
                    dto.id,
                    dto.car.let { carMapper.dtoToEntity(it!!) },
                    dto.client.let { clientMapper.dtoToEntity(it!!) },
                    dto.price,
                    StringDateFomatter.stringToDate(dto.startDate),
                    StringDateFomatter.stringToDate(dto.endDate))


}