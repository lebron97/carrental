package com.rlebron.carrental.service.Impl

import com.rlebron.carrental.dao.RentRepository
import com.rlebron.carrental.model.CarEntity
import com.rlebron.carrental.model.ClientEntity
import com.rlebron.carrental.model.RentEntity
import com.rlebron.carrental.service.GenericService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class RentServiceImpl @Autowired constructor(val rentRepository: RentRepository, val carService: GenericService<CarEntity>, val clientService: GenericService<ClientEntity>): GenericService<RentEntity> {

    override fun findAll(pageable: Pageable): Page<RentEntity> = rentRepository.findAll(pageable)

    override fun findById(id: Int): Optional<RentEntity> = rentRepository.findById(id)

    override fun create(rent: RentEntity): RentEntity {

        return if(carService.findById(rent.car!!.idCar!!).map { v -> v == rent.car }.orElse(false) && clientService.findById(rent.client!!.idClient!!).map { v -> v == rent.client }.orElse(false)){
            rentRepository.save(rent)
        }else{
            RentEntity()
        }

    }

    override fun update(id: Int, rent: RentEntity): Optional<RentEntity> = findById(id).map { rentRepository.save(RentEntity(id, rent.car, rent.client, rent.rentPrice, rent.rentStartDate, rent.rentExpirationDate)) }

    override fun delete(id: Int) = rentRepository.deleteById(id)
}