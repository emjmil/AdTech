package com.example.fullscreenad

import com.example.domain.Ad
import com.example.fullscreenad.model.AdsModel

class FullScreenAdMapper(
    val actionBuilder : FullScreenAdActionBuilder
) {

    fun mapTo(invoke: Ad): AdsModel{
        return AdsModel(
            imageUrl = invoke.imageUrl,
            trackingUrl = invoke.trackingUrl,
            openAction = actionBuilder.open(),
            closeAction = actionBuilder.close(),
            showAction = actionBuilder.shown()
        )
    }
}