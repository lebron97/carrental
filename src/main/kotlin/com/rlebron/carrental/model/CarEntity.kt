package com.rlebron.carrental.model

import com.rlebron.carrental.dto.CarDto
import javax.persistence.*

@Entity
@Table(name = "car")
data class CarEntity(@Id @GeneratedValue(strategy = GenerationType.AUTO) var idCar: Int = 0,
                     val carPlate: String = "",
                     val registrationYear: String = "",
                     val make: String = "",
                     val model: String = "",
                     @ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY) val rates: Set<RateEntity> = HashSet(),
                     @OneToMany(mappedBy = "car") val rents: Set<RentEntity> = HashSet())
//Al inicializar cada campo del constructor obtengo un constructor vacío