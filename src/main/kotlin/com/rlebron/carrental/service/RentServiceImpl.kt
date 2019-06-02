package com.rlebron.carrental.service

import com.rlebron.carrental.dao.ClientRepository
import com.rlebron.carrental.dao.RentRepository
import com.rlebron.carrental.model.ClientEntity
import com.rlebron.carrental.model.RentEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class RentServiceImpl @Autowired constructor(val rentRepository: RentRepository): GenericService<RentEntity> {

    override fun findAll(pageable: Pageable): Page<RentEntity> = rentRepository.findAll(pageable)

    override fun findById(id: Int): Optional<RentEntity> = rentRepository.findById(id)

    override fun create(rent: RentEntity): RentEntity = rentRepository.save(rent)

    override fun update(id: Int, rent: RentEntity): Optional<RentEntity> = findById(id).map { rentRepository.save(rent) }

    override fun delete(id: Int) = rentRepository.deleteById(id)
}