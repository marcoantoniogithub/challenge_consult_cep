package com.example.challenge_consult_cep.feature.search_cep.data.remote.api

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.ApiCepDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCepApi {

    @GET("https://cdn.apicep.com/file/apicep/{cep}.json")
    suspend fun getCep(
        @Path("cep") cep:String
    ): ApiCepDTO
}