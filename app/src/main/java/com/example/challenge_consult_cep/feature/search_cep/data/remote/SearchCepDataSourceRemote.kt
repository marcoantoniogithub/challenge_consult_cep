package com.example.challenge_consult_cep.feature.search_cep.data.remote

import com.example.challenge_consult_cep.feature.search_cep.data.mapper.toCep
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.ApiCepApi
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.AwesomeApiApi
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.ViaCepApi
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep

class SearchCepDataSourceRemote(
    private val apiCepApi: ApiCepApi,
    private val awesomeApiApi: AwesomeApiApi,
    private val viaCepApi: ViaCepApi,
) {

    suspend fun getCep(cep: String): Cep {
        return try {
            return viaCepApi.getCep(cep).toCep()
        } catch (e: Exception) {
            try {
                val newCep = cep.substring(0, 5) + "-" + cep.substring(5, 8)
                return apiCepApi.getCep(newCep).toCep()
            } catch (e: Exception) {
                try {
                    return awesomeApiApi.getCep(cep).toCep()
                } catch (e: Exception) {
                    throw Exception(e)
                }
            }
        }
    }
}