package com.rlebron.carrental.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "rent")
data class RentEntity(@Id @GeneratedValue(strategy = GenerationType.AUTO) val idRent: Int = 0,
                      @ManyToOne val car: CarEntity? = null,
                      @ManyToOne val client: ClientEntity? = null,
                      val rentPrice: Double = 0.0,
                      val rentStartDate: LocalDate? = null,
                      val rentExpirationDate: LocalDate? = null)