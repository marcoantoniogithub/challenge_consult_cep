package com.example.challenge_consult_cep.feature.search_cep.data.local

import com.example.challenge_consult_cep.feature.search_cep.data.local.dao.CepDAO
import com.example.challenge_consult_cep.feature.search_cep.data.mapper.toCep
import com.example.challenge_consult_cep.feature.search_cep.data.mapper.toCepEntity
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep

class SearchCepDataSourceLocal(
    private val cache: CepDAO
) {

    suspend fun getById(cep: String): Cep {
        return cache.findByCep(cep).toCep()
    }

    suspend fun insertItem(cep: Cep) {
        cache.insertItem(cep.toCepEntity())
    }
}