package com.example.challenge_consult_cep.feature.search_cep.domain.repository;

import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep;

import io.reactivex.rxjava3.core.Single;


public interface SearchCepRepository {

    Single<Cep> getCep(String cep);
}