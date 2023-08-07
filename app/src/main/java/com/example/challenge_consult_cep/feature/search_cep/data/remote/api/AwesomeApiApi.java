package com.example.challenge_consult_cep.feature.search_cep.data.remote.api;

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.AwesomeApiDTO;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AwesomeApiApi {

    @GET("https://cep.awesomeapi.com.br/json/{cep}")
    Single<AwesomeApiDTO> getCep(@Path("cep") String cep);
}