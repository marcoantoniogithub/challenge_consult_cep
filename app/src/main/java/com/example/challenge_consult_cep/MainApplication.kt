package com.example.challenge_consult_cep

import android.app.Application
import com.example.challenge_consult_cep.core.di.CoreModule
import com.example.challenge_consult_cep.feature.search_cep.di.SearchCepModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    SearchCepModule.instance,
                    CoreModule.instance
                )
            )
        }
    }
}