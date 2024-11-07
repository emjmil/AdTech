package com.example.sdkad

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fullscreenad.FullScreenAdViewModelImpl
import com.example.fullscreenad.FullScreenAds
import com.example.fullscreenad.di.fullScreenModule
import com.example.remote.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.startKoin
import java.util.UUID

object SDKInitializer {
    private var isInitialized = false
  //  val viewModel: FullScreenAdViewModelImpl = koinViewModel()

    private lateinit var viewModel: FullScreenAdViewModelImpl
    fun initSdk(
        context: Context,
        uuid: UUID
    ) {
        startKoin {
            androidContext(context)
            modules(
                repositoryModule,
                fullScreenModule,
                koinModules
            )
        }
        viewModel = FullScreenAdViewModelImpl()
        isInitialized = true
    }


    @Composable
    fun DisplayFulScreenAd(
        modifier: Modifier = Modifier
    ) {
        if (isInitialized.not()) {
            throw IllegalStateException("SDK not initialized")
        }
        val modelState = viewModel.state.collectAsStateWithLifecycle().value
        modelState ?: return
        FullScreenAds(
            modifier = modifier,
            model = modelState
        )
    }
}