package com.rlebron.carrental.dao

import com.rlebron.carrental.model.CarEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface CarRepository : JpaRepository<CarEntity, Int>{

    /*@Query(value = "SELECT u from User u WHERE u.city.name = ?1")
    fun findCocheMasRentablePorRangoDeFechas(startDate: LocalDate, expirationDate: LocalDate): CarEntity*/

}