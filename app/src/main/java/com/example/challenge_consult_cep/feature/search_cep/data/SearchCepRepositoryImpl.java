package com.example.challenge_consult_cep.feature.search_cep.data;

import com.example.challenge_consult_cep.feature.search_cep.data.local.SearchCepDataSourceLocal;
import com.example.challenge_consult_cep.feature.search_cep.data.remote.SearchCepDataSourceRemote;
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep;
import com.example.challenge_consult_cep.feature.search_cep.domain.repository.SearchCepRepository;

import io.reactivex.rxjava3.core.Single;

public class SearchCepRepositoryImpl implements SearchCepRepository {

    private SearchCepDataSourceRemote remote;
    private SearchCepDataSourceLocal local;

    public SearchCepRepositoryImpl(SearchCepDataSourceRemote remote, SearchCepDataSourceLocal local) {
        this.remote = remote;
        this.local = local;
    }

    @Override
    public Single<Cep> getCep(String cep) {
        return local.getById(cep)
            .onErrorResumeNext(v ->
                remote.getCep(cep)
                    .doOnSuccess(response -> {
                        local.insertItem(response)
                            .doOnComplete(() -> {
                                    System.out.println("deu");
                                }
                            ).doOnError(c -> {
                                    System.out.println(c);
                                });
                    })
            );
    }
}