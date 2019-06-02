package com.rlebron.carrental.service.Impl

import com.rlebron.carrental.dao.RateRepository
import com.rlebron.carrental.model.RateEntity
import com.rlebron.carrental.service.RateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RateServiceImpl@Autowired constructor(val rateRepository : RateRepository) : RateService {

    override fun create(ent: RateEntity): RateEntity = rateRepository.save(ent)
}