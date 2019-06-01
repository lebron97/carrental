package com.rlebron.carrental.mapper

interface Mapper<T,S> {

    fun entityToDto(ent : T) : S

    fun entityToDtoList(entList : List<T>) : List<S>

    fun dtoToEntity(dto : S) : T
}