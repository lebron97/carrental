package com.rlebron.carrental.dto

import javax.validation.constraints.NotNull

class RateDto(@NotNull val id: Int = 0,
              val price: Double = 0.0,
              val startDate: String = "",
              val endDate: String = "")
