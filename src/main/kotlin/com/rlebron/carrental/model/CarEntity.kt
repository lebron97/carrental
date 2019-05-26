package com.rlebron.carrental.model

import javax.persistence.*

@Entity
@Table(name = "car")
data class CarEntity(@Id val carPlate: String,
                     val make: String,
                     val model: String,
                     @ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY) val rates: Set<RateEntity>?,
                     @OneToMany(mappedBy = "car") val rents: Set<RentEntity>?){

}