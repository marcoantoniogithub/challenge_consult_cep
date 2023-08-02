package com.example.challenge_consult_cep.core.di

import com.example.challenge_consult_cep.core.data_source.network.NetworkConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

object CoreModule {

    val instance = module {
        single<OkHttpClient> { NetworkConfig.providesOkHttpClient() }
        single<Retrofit> { NetworkConfig.provideRetrofit(get()) }
    }
}