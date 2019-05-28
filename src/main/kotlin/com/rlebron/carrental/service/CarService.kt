package com.rlebron.carrental.service

import com.rlebron.carrental.dto.CarDto
import com.rlebron.carrental.model.CarEntity


interface CarService {

    /**
     *Method to get all the cars in the data base
     *@return A list of all the cars
     */
    fun findAll(): List<CarDto>

    /**
     * Method to get a car by id
     * @param car id
     * @return car found or a empty car if it cannot be found
     */
    fun findById(idCar: Int): CarDto

    /**
     *Method to insert a new car
     *@param car data transfer object
     *@return the car inserted
     */
    fun create(car: CarDto): CarDto

    /**
     * Method to update a car
     * @param car data transfer object
     * @return the car updated
     */
    fun update(car: CarDto): CarDto

    /**
     * Method to delete a car by id
     * @param car id
     */
    fun delete(idCar: Int)
}