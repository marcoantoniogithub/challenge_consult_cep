package com.example.challenge_consult_cep.feature.search_cep.domain.use_case;

import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep;
import com.example.challenge_consult_cep.feature.search_cep.domain.repository.SearchCepRepository;

import io.reactivex.rxjava3.core.Single;

public class SearchCepUseCase {

    private final SearchCepRepository repository;

    public SearchCepUseCase(
            SearchCepRepository repository
    ) {
        this.repository = repository;
    }

    public Single<Cep> invoke(String cep) {
        return repository.getCep(cep);
    }
}