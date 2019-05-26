package com.rlebron.carrental.dao

import com.rlebron.carrental.model.RentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RentRepository : JpaRepository<RentEntity, Int>