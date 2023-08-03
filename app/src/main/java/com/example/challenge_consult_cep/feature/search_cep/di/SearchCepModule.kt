package com.example.challenge_consult_cep.feature.search_cep.di

import com.example.challenge_consult_cep.feature.search_cep.data.SearchCepRepositoryImpl
import com.example.challenge_consult_cep.feature.search_cep.data.local.SearchCepDataSourceLocal
import com.example.challenge_consult_cep.feature.search_cep.data.local.dao.CepDAO
import com.example.challenge_consult_cep.feature.search_cep.data.remote.SearchCepDataSourceRemote
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.ApiCepApi
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.AwesomeApiApi
import com.example.challenge_consult_cep.feature.search_cep.data.remote.api.ViaCepApi
import com.example.challenge_consult_cep.feature.search_cep.domain.repository.SearchCepRepository
import com.example.challenge_consult_cep.feature.search_cep.domain.use_case.SearchCepUseCase
import com.example.challenge_consult_cep.feature.search_cep.presentation.SearchCepViewModel
import com.example.challenge_consult_cep.core.data_source.data_base.AppDataBase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object SearchCepModule {

    val instance = module {
        viewModel { SearchCepViewModel(get()) }
        factory { SearchCepUseCase(get()) }
        factory<SearchCepRepository> { SearchCepRepositoryImpl(get(), get()) }
        factory { SearchCepDataSourceRemote(get(), get(), get()) }
        factory { SearchCepDataSourceLocal(get()) }
        factory<ApiCepApi> { provideApiCepApi(get()) }
        factory<AwesomeApiApi> { provideAwesomeApiApi(get()) }
        factory<ViaCepApi> { provideViaCepApi(get()) }
        factory<CepDAO> { provideDao(get()) }
    }


    fun provideApiCepApi(retrofit: Retrofit): ApiCepApi = retrofit.create(ApiCepApi::class.java)
    fun provideAwesomeApiApi(retrofit: Retrofit): AwesomeApiApi = retrofit.create(AwesomeApiApi::class.java)
    fun provideViaCepApi(retrofit: Retrofit): ViaCepApi = retrofit.create(ViaCepApi::class.java)

    fun provideDao(dataBase: AppDataBase): CepDAO {
        return dataBase.userDao()
    }
}