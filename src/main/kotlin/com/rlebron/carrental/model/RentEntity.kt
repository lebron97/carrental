package com.rlebron.carrental.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "rent")
data class RentEntity(@Id @GeneratedValue(strategy = GenerationType.AUTO) val idRent: Int,
                      val rentPrice: Double, val rentStartDate: Date,
                      val rentExpirationDate: Date,
                      @ManyToOne val car: CarEntity,
                      @ManyToOne val client: ClientEntity)