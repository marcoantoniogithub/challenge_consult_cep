package com.example.challenge_consult_cep.feature.search_cep.data.remote.api

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.ViaCepDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepApi {

    @GET("https://viacep.com.br/ws/{cep}/json/")
    suspend fun getCep(
        @Path("cep") cep:String
    ): ViaCepDTO
}