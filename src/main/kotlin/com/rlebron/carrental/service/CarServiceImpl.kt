package com.rlebron.carrental.service

import com.rlebron.carrental.dao.CarRepository
import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.mapper.CarMapperImpl
import com.rlebron.carrental.model.CarEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CarServiceImpl @Autowired constructor(val carRepository : CarRepository, val carMapper: CarMapperImpl) : CarService {


    override fun findAll(): List<CarDto> {

        val carDtoList = ArrayList<CarDto>()
        carRepository.findAll().forEach {carDtoList.add(carMapper.entityToDto(it))}

        return carDtoList
    }

    override fun create(car: CarEntity): CarEntity = carRepository.save(car)

}