package com.example.challenge_consult_cep.feature.search_cep.data.mapper

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.AwesomeApiDTO
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep

fun AwesomeApiDTO.toCep() = Cep(
    code = cep,
    state = state,
    city = city,
    neighborhood = district,
    address = address,
)