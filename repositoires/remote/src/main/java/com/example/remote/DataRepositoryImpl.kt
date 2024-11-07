package com.example.remote

import com.example.api.SdkApi
import com.example.api.model.AdResponse
import com.example.domain.Ad
import com.example.domain.DataRepository

class DataRepositoryImpl(val sdkApi: SdkApi): DataRepository {
    override suspend fun load(clientId: String) =  sdkApi.loadAd(clientId).map()

    override suspend fun tracking(url: String, header: String) {
        sdkApi.track(url, header)
    }
}

fun AdResponse.map() = Ad(
    imageUrl = this.imageUrl,
    closeDelay = this.closeDelay,
    trackingUrl = this.trackingUrl,
    clickThrough = this.clickThrough
)
