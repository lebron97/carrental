package com.rlebron.carrental.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface GenericService<T> {

    /**
     *Method to get all the T in the data base
     * @param pageable
     *@return A list of all the T
     */
    fun findAll(pageable: Pageable): Page<T>

    /**
     * Method to get a T by id
     * @param T id
     * @return optional of the T found
     */
    fun findById(id: Int): Optional<T>

    /**
     *Method to insert a new T
     *@param T entity
     *@return the entity of the T inserted
     */
    fun create(t: T): T

    /**
     * Method to update a T
     * @param T entity
     * @return the T updated
     */
    fun update(id: Int, t: T): Optional<T>

    /**
     * Method to delete a T by id
     * @param T id
     */
    fun delete(id: Int)
}