package com.rlebron.carrental.dao

import com.rlebron.carrental.model.CarEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface CarRepository : JpaRepository<CarEntity, Int>{

    @Query(nativeQuery = true, value = "SELECT all from car ce JOIN rent re ON ce.idCar = re.car.idCar WHERE re.rentStartDate BETWEEN ?1 AND ?2 OR re.rentExpirationDate BETWEEN ?1 AND ?2 " +
            "AND re.precio = (SELECT MAX (precio / DATEDIFF(mre.rentStartDate,mre.rentExpirationDate))) FROM rent mre")
    fun findCocheMasRentablePorRangoDeFechas(startDate: LocalDate, expirationDate: LocalDate): CarEntity

}