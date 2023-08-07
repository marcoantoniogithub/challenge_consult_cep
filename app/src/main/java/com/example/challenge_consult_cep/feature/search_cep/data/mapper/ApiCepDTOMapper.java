package com.example.challenge_consult_cep.feature.search_cep.data.mapper;

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.ApiCepDTO;
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep;

public final class ApiCepDTOMapper {
    public static Cep toCep(ApiCepDTO apiCepDTO) {
        return new Cep(apiCepDTO.getCode().replace("-", ""),
                apiCepDTO.getState(),
                apiCepDTO.getCity(),
                apiCepDTO.getDistrict(),
                apiCepDTO.getAddress()
        );
    }

}