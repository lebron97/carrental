package com.rlebron.carrental.service

import com.rlebron.carrental.dao.CarRepository
import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.mapper.CarMapperImpl
import com.rlebron.carrental.mapper.Mapper
import com.rlebron.carrental.model.CarEntity
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class CarServiceImpl @Autowired constructor(val carRepository : CarRepository, val carMapper: Mapper<CarEntity, CarDto>) : CarService {

    override fun findAll(): List<CarDto> {
        val carDtoList = ArrayList<CarDto>()
        carRepository.findAll().forEach {carDtoList.add(carMapper.entityToDto(it))}
        return carDtoList
    }

    override fun findById(idCar: Int): CarDto = carMapper.entityToDto(carRepository.findById(idCar).orElseThrow { NotFoundException("Car not found") })

    override fun create(car: CarDto): CarDto {
        carRepository.save(carMapper.dtoToEntity(car))
        return car
    }

    override fun update(car: CarDto): CarDto {
        carRepository.save(carMapper.dtoToEntity(Optional.ofNullable(findById(car.id)).orElseThrow{NotFoundException("Car not found")}))
        return car
    }

    override fun delete(idCar: Int) {
        carRepository.deleteById(idCar)
    }

}