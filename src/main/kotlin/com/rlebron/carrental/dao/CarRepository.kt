package com.rlebron.carrental.dao

import com.rlebron.carrental.model.CarEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository : JpaRepository<CarEntity, String>