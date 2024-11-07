package com.example.domain.di

import com.example.domain.LoadDataUseCase
import com.example.domain.TrackDataUseCase
import org.koin.dsl.module

val domainModule  = module {

    factory {
        LoadDataUseCase(repository = get())
    }

    factory {
        TrackDataUseCase(repository = get())
    }
}
