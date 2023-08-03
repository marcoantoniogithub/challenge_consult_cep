package com.example.challenge_consult_cep.feature.search_cep.data.mapper

import com.example.challenge_consult_cep.feature.search_cep.data.local.entity.CepEntity
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep

fun CepEntity.toCep() = Cep(
    code = code,
    state = state,
    city = city,
    neighborhood = neighborhood,
    address = address,
)

fun Cep.toCepEntity() = CepEntity(
    code = code,
    state = state,
    city = city,
    neighborhood = neighborhood,
    address = address,
)