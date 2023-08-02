package com.example.challenge_consult_cep.feature.search_cep.domain.repository

import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep

interface SearchCepRepository {

    suspend fun getCep(cep: String): Cep
}