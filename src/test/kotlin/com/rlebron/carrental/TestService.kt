package com.rlebron.carrental

import com.rlebron.carrental.dao.CarRepository
import com.rlebron.carrental.model.CarEntity
import com.rlebron.carrental.service.Impl.CarServiceImpl
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.data.domain.PageRequest
import java.util.ArrayList

@RunWith(MockitoJUnitRunner::class)
class TestService {

    @InjectMocks
    lateinit var carService: CarServiceImpl

    @Mock
    lateinit var carRepository: CarRepository

    @Test
    fun testBusquedaTodosLosCoche() {
        val cochesResultado = ArrayList<CarEntity>()

        for (i in 0..10) {
            cochesResultado.add(CarEntity(i, "1234ASD", "2010"))
        }
        val cochesEnBd = ArrayList(cochesResultado)
        cochesEnBd.add(CarEntity(11, "1234ASD","2010"))

        Mockito.`when`(carRepository.findAll()).thenReturn(cochesResultado)

        //No se que pasa cuando llega aquí que es nulo y necesito dormir
        val resultado = carService.findAll(PageRequest.of(0, 10))
        Assert.assertNotNull(resultado)
        Assert.assertEquals(resultado.size.toLong(), (cochesEnBd.size - 1).toLong())
    }
}