package com.example.challenge_consult_cep.feature.search_cep.data

import com.example.challenge_consult_cep.feature.search_cep.data.local.SearchCepDataSourceLocal
import com.example.challenge_consult_cep.feature.search_cep.data.remote.SearchCepDataSourceRemote
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep
import com.example.challenge_consult_cep.feature.search_cep.domain.repository.SearchCepRepository

class SearchCepRepositoryImpl(
    private val remote: SearchCepDataSourceRemote,
    private val local: SearchCepDataSourceLocal
) : SearchCepRepository{

    override suspend fun getCep(cep: String): Cep {
        try {
            return remote.getCep(cep)
        } catch (e: Exception) {
            throw e
        }
    }
}