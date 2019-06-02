package com.rlebron.carrental.service.Impl

import com.rlebron.carrental.dao.ClientRepository
import com.rlebron.carrental.model.ClientEntity
import com.rlebron.carrental.service.GenericService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClientServiceImpl @Autowired constructor(val clientRepository: ClientRepository): GenericService<ClientEntity> {

    override fun findAll(pageable: Pageable): Page<ClientEntity> = clientRepository.findAll(pageable)

    override fun findById(id: Int): Optional<ClientEntity> = clientRepository.findById(id)

    override fun create(client: ClientEntity): ClientEntity = clientRepository.save(client)

    override fun update(id: Int, client: ClientEntity): Optional<ClientEntity>  = findById(id).map { clientRepository.save(ClientEntity(id, client.dni, client.name))}

    override fun delete(id: Int) = clientRepository.deleteById(id)

}