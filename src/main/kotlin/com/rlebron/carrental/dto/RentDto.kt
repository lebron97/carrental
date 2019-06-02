package com.rlebron.carrental.dto

import javax.validation.constraints.NotNull

class RentDto(val id: Int? = 0,
              @NotNull val car: CarDto? = null,
              @NotNull val client: ClientDto? = null,
              val price: Double? = 0.0,
              val startDate: String? = "",
              val endDate: String? = "")
