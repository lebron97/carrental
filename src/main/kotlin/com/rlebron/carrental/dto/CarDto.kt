package com.rlebron.carrental.dto

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Size

class CarDto(@NotNull val id: Int = 0,
             @NotNull @Size(min = 7) val carPlate: String = "",
             val registrationYear: String = "")