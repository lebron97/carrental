package com.rlebron.carrental.service

import com.rlebron.carrental.dao.CarRepository
import com.rlebron.carrental.model.CarEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*


@Service
class CarServiceImpl @Autowired constructor(val carRepository : CarRepository) : CarService {

    override fun findAll(pageable: Pageable): List<CarEntity> = carRepository.findAll()

    override fun findById(idCar: Int): Optional<CarEntity> = carRepository.findById(idCar)

    override fun create(car: CarEntity): CarEntity = carRepository.save(car)

    override fun update(id: Int, car: CarEntity): Optional<CarEntity> = findById(id).map {e -> carRepository.save(e) }

    override fun delete(idCar: Int) = carRepository.deleteById(idCar)
}