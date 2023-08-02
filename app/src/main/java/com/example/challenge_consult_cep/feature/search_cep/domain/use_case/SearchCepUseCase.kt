package com.example.challenge_consult_cep.feature.search_cep.domain.use_case

import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep
import com.example.challenge_consult_cep.feature.search_cep.domain.repository.SearchCepRepository

class SearchCepUseCase(
    private val repository: SearchCepRepository
) {

    suspend fun getUsers(cep: String): Cep = repository.getCep(cep)
}