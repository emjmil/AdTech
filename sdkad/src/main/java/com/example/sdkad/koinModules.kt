package com.example.sdkad

import com.example.fullscreenad.FullScreenAdViewModelImpl
import com.example.fullscreenad.di.fullScreenModule
import com.example.remote.di.repositoryModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModules = module {
    viewModel {
        FullScreenAdViewModelImpl(
            //mapperFactory = get()
        )
    }
}