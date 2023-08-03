package com.example.challenge_consult_cep.core.di

import android.content.Context
import androidx.room.Room
import com.example.challenge_consult_cep.core.data_source.data_base.AppDataBase
import com.example.challenge_consult_cep.core.data_source.network.NetworkConfig
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

object CoreModule {

    val instance = module {
        single<OkHttpClient> { NetworkConfig.providesOkHttpClient() }
        single<Retrofit> { NetworkConfig.provideRetrofit(get()) }
        single<AppDataBase> { provideDataBase(androidContext()) }
    }

    fun provideDataBase(context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "app_database").build()
    }
}