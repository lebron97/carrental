package com.rlebron.carrental.dao

import com.rlebron.carrental.model.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<ClientEntity, Int>