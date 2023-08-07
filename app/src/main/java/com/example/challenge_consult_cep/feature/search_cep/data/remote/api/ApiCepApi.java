package com.example.challenge_consult_cep.feature.search_cep.data.remote.api;

import com.example.challenge_consult_cep.feature.search_cep.data.remote.dto.ApiCepDTO;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiCepApi {

    @GET("https://cdn.apicep.com/file/apicep/{cep}.json")
    Single<ApiCepDTO> getCep(@Path("cep") String cep);
}