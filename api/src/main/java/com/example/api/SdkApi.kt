package com.example.api

import com.example.api.model.AdResponse

interface SdkApi {
    suspend fun loadAd(clientId: String): AdResponse
    suspend fun track(url: String, header: String)
}