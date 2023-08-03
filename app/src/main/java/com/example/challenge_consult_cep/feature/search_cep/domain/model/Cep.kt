package com.example.challenge_consult_cep.feature.search_cep.domain.model

data class Cep(
    var code: String,
    var state: String,
    var city: String,
    var neighborhood: String,
    var address: String,
)
