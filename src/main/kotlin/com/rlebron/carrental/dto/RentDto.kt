package com.rlebron.carrental.dto

import javax.validation.constraints.NotNull

class RentDto(@NotNull val id: Int? = 0,
              val car: CarDto? = null,
              val client: ClientDto? = null,
              val price: Double? = 0.0,
              val startDate: String? = "",
              val endDate: String? = "")
