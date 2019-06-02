package com.rlebron.carrental.model

import java.time.LocalDate
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
@Table(name = "rate")
data class RateEntity(@Id @GeneratedValue(strategy = GenerationType.AUTO) val rateId: Int = 0,
                      val ratePrice: Double = 0.0,
                      val rateStartDate: LocalDate? = null,
                      val rateExpirationDate: LocalDate? = null,
                      @ManyToMany(fetch = FetchType.LAZY) val cars: Set<CarEntity> = HashSet())