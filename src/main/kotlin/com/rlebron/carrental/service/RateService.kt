package com.rlebron.carrental.service

import com.rlebron.carrental.model.RateEntity

interface RateService {
    /**
     *Method to insert a new T
     *@param rate entity
     *@return the entity of the T inserted
     */
    fun create(ent: RateEntity): RateEntity
}