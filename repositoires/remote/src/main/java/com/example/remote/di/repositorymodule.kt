package com.example.remote.di

import com.example.api.di.apiKoinModule
import com.example.domain.DataRepository
import com.example.domain.di.domainModule
import com.example.remote.DataRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module  {
    includes(apiKoinModule, domainModule)

    single<DataRepository> {
        DataRepositoryImpl(sdkApi = get())
    }

}