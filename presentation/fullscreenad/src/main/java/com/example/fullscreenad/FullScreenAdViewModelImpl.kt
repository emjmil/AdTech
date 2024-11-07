package com.example.fullscreenad

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.LoadDataUseCase
import com.example.domain.TrackDataUseCase
import com.example.fullscreenad.model.AdsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FullScreenAdViewModelImpl(
   // private val clientId: String,
) : ViewModel(), FullScreenAdViewModel, FullScreenAdExecutor, KoinComponent {

    val loadUseCase by inject<LoadDataUseCase>()
    val trackUseCase by inject<TrackDataUseCase>()
    val mapperFactory by inject<FullScreenAdMapperFactory>()
    private val mapper = mapperFactory.create(this)
    private val _state: MutableStateFlow<AdsModel?> = MutableStateFlow(null)
    val state =  _state.asStateFlow().onStart {
        loadAd()
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    private fun loadAd() {
       viewModelScope.launch(Dispatchers.IO) {
           _state.value = mapper.mapTo(loadUseCase.invoke("clientId"))
       }
    }

    override fun closeAd() {
        track( "ad_close")
    }

    override fun openAd() {
        track( "ad_click")
    }

    override fun showAd() {
        track( "ad_shown")
    }

    private fun track(header: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value?.trackingUrl?.let {
                trackUseCase.invoke(it, header)
            }
        }
    }

}
