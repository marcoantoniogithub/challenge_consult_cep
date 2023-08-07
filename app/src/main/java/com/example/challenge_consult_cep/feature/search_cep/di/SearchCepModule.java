package com.example.challenge_consult_cep.feature.search_cep.di;

import static com.example.challenge_consult_cep.core.data_source.network.NetworkConfig.providesOkHttpClient;
import static com.example.challenge_consult_cep.core.di.CoreModule.provideDataBase;
import static com.example.challenge_consult_cep.core.di.CoreModule.provideRetrofit;

import android.content.Context;

import com.example.challenge_consult_cep.core.data_source.data_base.AppDataBase;
import com.example.challenge_consult_cep.feature.search_cep.data.SearchCepRepositoryImpl;
import com.example.challenge_consult_cep.feature.search_cep.data.local.SearchCepDataSourceLocal;
import com.example.challenge_consult_cep.feature.search_cep.data.local.dao.CepDAO;
import com.example.challenge_consult_cep.feature.search_cep.data.remote.SearchCepDataSourceRemote;
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.ApiCepApi;
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.AwesomeApiApi;
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.ViaCepApi;
import com.example.challenge_consult_cep.feature.search_cep.domain.repository.SearchCepRepository;
import com.example.challenge_consult_cep.feature.search_cep.domain.use_case.SearchCepUseCase;
import com.example.challenge_consult_cep.feature.search_cep.presentation.SearchCepViewModel;

import retrofit2.Retrofit;

public class SearchCepModule {

    public static SearchCepViewModel provideSearchCepViewModel(Context context) {
        return new SearchCepViewModel(provideSearchCepUseCase(context));
    }

    public static SearchCepUseCase provideSearchCepUseCase(Context context) {
        return new SearchCepUseCase(provideSearchCepRepository(context));
    }

    public static SearchCepRepository provideSearchCepRepository(Context context) {
        return new SearchCepRepositoryImpl(provideSearchCepDataSourceRemote(), provideSearchCepDataSourceLocal(context));
    }

    public static SearchCepDataSourceRemote provideSearchCepDataSourceRemote() {
        return new SearchCepDataSourceRemote(provideApiCepApi(provideRetrofit(providesOkHttpClient())), provideAwesomeApiApi(provideRetrofit(providesOkHttpClient())), provideViaCepApi(provideRetrofit(providesOkHttpClient())));
    }

    public static SearchCepDataSourceLocal provideSearchCepDataSourceLocal(Context context) {
        return new SearchCepDataSourceLocal(provideCepDao(provideDataBase(context)));
    }

    public static ApiCepApi provideApiCepApi(Retrofit retrofit) {
        return retrofit.create(ApiCepApi.class);
    }

    public static AwesomeApiApi provideAwesomeApiApi(Retrofit retrofit) {
        return retrofit.create(AwesomeApiApi.class);
    }

    public static ViaCepApi provideViaCepApi(Retrofit retrofit) {
        return retrofit.create(ViaCepApi.class);
    }

    public static CepDAO provideCepDao(AppDataBase dataBase) {
        return dataBase.cepDao();
    }
}