package com.rlebron.carrental.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class ClientDto(@NotNull val id: Int = 0,
                @NotNull @Size(min = 9) val dni: String = "",
                val name: String = "")