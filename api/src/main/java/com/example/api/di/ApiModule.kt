package com.example.api.di

import com.example.api.RetrofitSdkApiImpl
import com.example.api.SdkApi
import com.example.api.createSdkApi
import org.koin.dsl.module

val apiKoinModule = module {
    single {
        createSdkApi()
    }
    single<SdkApi> {
        RetrofitSdkApiImpl(retrofit = get())
    }
}