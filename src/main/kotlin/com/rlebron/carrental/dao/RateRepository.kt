package com.rlebron.carrental.dao

import com.rlebron.carrental.model.RateEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RateRepository : JpaRepository<RateEntity, Int>