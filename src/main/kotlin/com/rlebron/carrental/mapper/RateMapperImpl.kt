package com.rlebron.carrental.mapper

import com.rlebron.carrental.dto.RateDto
import com.rlebron.carrental.model.RateEntity
import com.rlebron.carrental.utils.StringDateFomatter
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

@Component
class RateMapperImpl : RateMapper<RateEntity, RateDto> {

    override fun entityToDto(ent: RateEntity): RateDto =
            RateDto(
                    ent.rateId,
                    ent.ratePrice,
                    ent.rateStartDate.toString(),
                    ent.rateExpirationDate.toString()
            )

    override fun dtoToEntity(dto: RateDto): RateEntity {
            return RateEntity(
                    dto.id,
                    dto.price,
                    StringDateFomatter.stringToDate(dto.startDate),
                    StringDateFomatter.stringToDate(dto.endDate))

    }

}