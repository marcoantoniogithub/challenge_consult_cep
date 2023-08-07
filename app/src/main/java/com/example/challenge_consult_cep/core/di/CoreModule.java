package com.example.challenge_consult_cep.core.di;

import android.content.Context;

import androidx.room.Room;

import com.example.challenge_consult_cep.core.data_source.data_base.AppDataBase;
import com.example.challenge_consult_cep.core.data_source.network.NetworkConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class CoreModule {

    public static OkHttpClient provideOkHttpClient() {
        return NetworkConfig.providesOkHttpClient();
    }

    public static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return NetworkConfig.provideRetrofit(okHttpClient);
    }

    public static AppDataBase provideDataBase(Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, "app_database").build();
    }
}