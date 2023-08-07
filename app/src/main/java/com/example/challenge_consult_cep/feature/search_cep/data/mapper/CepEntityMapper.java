package com.example.challenge_consult_cep.feature.search_cep.data.mapper;

import com.example.challenge_consult_cep.feature.search_cep.data.local.entity.CepEntity;
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep;

public class CepEntityMapper {
    public static CepEntity toCepEntity(Cep cep) {
        return new CepEntity(cep.getCode(),
                cep.getState(),
                cep.getCity(),
                cep.getNeighborhood(),
                cep.getAddress()
        );
    }

    public static Cep toCep(CepEntity cepEntity) {
        return new Cep(
                cepEntity.getCode(),
                cepEntity.getState(),
                cepEntity.getCity(),
                cepEntity.getNeighborhood(),
                "Rua " + cepEntity.getAddress());
    }
}