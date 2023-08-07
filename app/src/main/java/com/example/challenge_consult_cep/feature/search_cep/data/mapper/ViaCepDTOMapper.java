package com.example.challenge_consult_cep.feature.search_cep.data.mapper;

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.ViaCepDTO;
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep;

public class ViaCepDTOMapper {
    public static Cep toCep(ViaCepDTO viaCepDTO) {
        return new Cep(viaCepDTO.getCep().replace("-", ""), viaCepDTO.getUf(), viaCepDTO.getLocalidade(), viaCepDTO.getBairro(), "Rua " + viaCepDTO.getLogradouro());
    }
}
