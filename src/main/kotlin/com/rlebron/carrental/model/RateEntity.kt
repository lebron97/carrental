package com.rlebron.carrental.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "rate")
data class RateEntity(@Id val rateId: Int,
                      val ratePrice: Double,
                      val rateStartDate: Date,
                      val rateExpirationDate: Date,
                      @ManyToMany(fetch = FetchType.LAZY) val cars: Set<CarEntity>)