package com.rlebron.carrental.mapper

import org.springframework.data.domain.Page

interface Mapper<T,S> {

    //No he conseguido que me funcione el modelMapper en kotlin

    /**
     * Method for map entity to dto
     * @param generic
     * @return generic
     */
    fun entityToDto(ent : T) : S

    /**
     * Method for map a list of entities to dto
     * @param generic List
     * @return generic List
     */
    fun entityToDtoList(entList : Page<T>) : Page<S>

    /**
     * Method for map dto to entity
     * @param generic
     * @return generic
     */
    fun dtoToEntity(dto : S) : T
}