package com.example.challenge_consult_cep.feature.search_cep.data.local;

import com.example.challenge_consult_cep.feature.search_cep.data.local.dao.CepDAO;
import com.example.challenge_consult_cep.feature.search_cep.data.mapper.CepEntityMapper;
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class SearchCepDataSourceLocal {

    private CepDAO cache;

    public SearchCepDataSourceLocal(
            CepDAO cache
    ) {
        this.cache = cache;
    }

    public Single<Cep> getById(String cep) {
        return cache.findByCep(cep)
                .map(CepEntityMapper::toCep);
    }

    public Completable insertItem(Cep cep) {
        return cache.insertItem(CepEntityMapper.toCepEntity(cep));
    }
}