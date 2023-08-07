package com.example.challenge_consult_cep.feature.search_cep.data.remote.api;

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.ViaCepDTO;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ViaCepApi {

    @GET("https://viacep.com.br/ws/{cep}/json/")
    Single<ViaCepDTO> getCep(@Path("cep") String cep);
}