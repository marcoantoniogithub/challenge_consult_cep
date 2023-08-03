package com.example.challenge_consult_cep.feature.search_cep.mock

import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep

object CepMock {

    fun mockedCep() = Cep(
        code = "04538133",
        state = "SP",
        city = "São Paulo",
        neighborhood = "Itaim Bibi",
        address = "Rua Avenida Brigadeiro Faria Lima"
    )
}