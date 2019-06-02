package com.rlebron.carrental.mapper

interface RateMapper<T,S> {

    /**
     * Method for map entity to dto
     * @param generic
     * @return generic
     */
    fun entityToDto(ent : T) : S

    /**
     * Method for map dto to entity
     * @param generic
     * @return generic
     */
    fun dtoToEntity(dto : S) : T
}