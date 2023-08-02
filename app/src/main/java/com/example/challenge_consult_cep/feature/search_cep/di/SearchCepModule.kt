package com.example.challenge_consult_cep.feature.search_cep.di

import com.example.challenge_consult_cep.feature.search_cep.data.SearchCepRepositoryImpl
import com.example.challenge_consult_cep.feature.search_cep.data.local.SearchCepDataSourceLocal
import com.example.challenge_consult_cep.feature.search_cep.data.remote.SearchCepDataSourceRemote
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.ApiCepApi
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.AwesomeApiApi
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.ViaCepApi
import com.example.challenge_consult_cep.feature.search_cep.domain.repository.SearchCepRepository
import com.example.challenge_consult_cep.feature.search_cep.domain.use_case.SearchCepUseCase
import com.example.challenge_consult_cep.feature.search_cep.ui.SearchCepViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object SearchCepModule {

    val instance = module {
        viewModel { SearchCepViewModel(get()) }
        factory { SearchCepUseCase(get()) }
        factory<SearchCepRepository> { SearchCepRepositoryImpl(get(), get()) }
        factory { SearchCepDataSourceRemote(get(), get(), get()) }
        factory { SearchCepDataSourceLocal() }
        factory<ApiCepApi> { provideApiCepApi(get()) }
        factory<AwesomeApiApi> { provideAwesomeApiApi(get()) }
        factory<ViaCepApi> { provideViaCepApi(get()) }
    }


    fun provideApiCepApi(retrofit: Retrofit): ApiCepApi = retrofit.create(ApiCepApi::class.java)
    fun provideAwesomeApiApi(retrofit: Retrofit): AwesomeApiApi = retrofit.create(AwesomeApiApi::class.java)
    fun provideViaCepApi(retrofit: Retrofit): ViaCepApi = retrofit.create(ViaCepApi::class.java)
}