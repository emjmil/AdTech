package com.example.fullscreenad.di

import com.example.fullscreenad.FullScreenAdMapperFactory
import org.koin.dsl.module

val fullScreenModule = module {
    factory {
        FullScreenAdMapperFactory()
    }
}
