package com.rlebron.carrental.mapper

interface Mapper<T,S> {

    fun entityToDto(ent : T) : S

    fun dtoToEntity(dto : S) : T
}