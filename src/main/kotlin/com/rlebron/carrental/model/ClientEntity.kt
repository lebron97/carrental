package com.rlebron.carrental.model

import javax.persistence.*

@Entity
@Table(name = "client")
data class ClientEntity(@Id @GeneratedValue(strategy = GenerationType.AUTO) val idClient: Int = 0,
                        val dni: String = "",
                        val name: String = "",
                        val surName: String = "",
                        @OneToMany(mappedBy = "client") var rents: Set<RentEntity> = HashSet())