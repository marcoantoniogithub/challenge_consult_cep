package com.example.challenge_consult_cep.feature.search_cep.data.mapper

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.ViaCepDTO
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep

fun ViaCepDTO.toCep() = Cep(
    code = cep,
    state = uf,
    city = localidade,
    neighborhood = bairro,
    address = "Rua $logradouro",
)