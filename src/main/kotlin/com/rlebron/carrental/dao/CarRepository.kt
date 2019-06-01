package com.rlebron.carrental.dao

import com.rlebron.carrental.model.CarEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CarRepository : JpaRepository<CarEntity, Int>{

    fun findByCarPlate(carPlate : String) : Optional<CarEntity>

}