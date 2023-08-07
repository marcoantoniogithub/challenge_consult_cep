package com.example.challenge_consult_cep.feature.search_cep.data.remote;

import com.example.challenge_consult_cep.feature.search_cep.data.mapper.ApiCepDTOMapper;
import com.example.challenge_consult_cep.feature.search_cep.data.mapper.AwesomeApiDTOMapper;
import com.example.challenge_consult_cep.feature.search_cep.data.mapper.ViaCepDTOMapper;
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.ApiCepApi;
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.AwesomeApiApi;
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.ViaCepApi;
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class SearchCepDataSourceRemote {

    private ApiCepApi apiCepApi;
    private AwesomeApiApi awesomeApiApi;
    private ViaCepApi viaCepApi;

    public SearchCepDataSourceRemote(ApiCepApi apiCepApi, AwesomeApiApi awesomeApiApi, ViaCepApi viaCepApi) {
        this.apiCepApi = apiCepApi;
        this.awesomeApiApi = awesomeApiApi;
        this.viaCepApi = viaCepApi;
    }

    public Single<Cep> getCep(String cep) {

        String cepWithHyphen = cep.substring(0, 5) + "-" + cep.substring(5, 8);

        return viaCepApi.getCep(cep).map(ViaCepDTOMapper::toCep)
                .onErrorResumeNext(one -> apiCepApi.getCep(cepWithHyphen).map(ApiCepDTOMapper::toCep))
                .onErrorResumeNext(two -> awesomeApiApi.getCep(cep).map(AwesomeApiDTOMapper::toCep));
    }
}