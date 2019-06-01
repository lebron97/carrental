package com.rlebron.carrental.service

import com.rlebron.carrental.model.CarEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*


interface CarService {

    /**
     *Method to get all the cars in the data base
     * @param pageable
     *@return A list of all the cars
     */
    fun findAll(pageable: Pageable): Page<CarEntity>

    /**
     * Method to get a car by id
     * @param car id
     * @return optional of the car found
     */
    fun findById(idCar: Int): Optional<CarEntity>

    /**
     *Method to insert a new car
     *@param car entity
     *@return the entity of the car inserted
     */
    fun create(car: CarEntity): CarEntity

    /**
     * Method to update a car
     * @param car entity
     * @return the car updated
     */
    fun update(id: Int, car: CarEntity): CarEntity

    /**
     * Method to delete a car by id
     * @param car id
     */
    fun delete(idCar: Int)
}