package com.example.challenge_consult_cep.feature.search_cep.data.mapper;

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.AwesomeApiDTO;
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep;


public class AwesomeApiDTOMapper {
    public static Cep toCep(AwesomeApiDTO awesomeApiDTO) {
        return new Cep(awesomeApiDTO.getCep().replace("-", ""),
                awesomeApiDTO.getState(),
                awesomeApiDTO.getCity(),
                awesomeApiDTO.getDistrict(),
                awesomeApiDTO.getAddress()
        );
    }

}