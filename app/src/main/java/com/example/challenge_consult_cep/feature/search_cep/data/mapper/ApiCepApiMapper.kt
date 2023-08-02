package com.example.challenge_consult_cep.feature.search_cep.data.mapper

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.ApiCepDTO
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep

fun ApiCepDTO.toCep() = Cep(
    code = code,
    state = state,
    city = city,
    neighborhood = district,
    address = address,
)