package com.example.challenge_consult_cep.feature.search_cep.data.remote.api

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.AwesomeApiDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface AwesomeApiApi {

    @GET("https://cep.awesomeapi.com.br/json/{cep}")
    suspend fun getCep(
        @Path("cep") cep: String
    ): AwesomeApiDTO
}