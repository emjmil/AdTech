package com.example.api

import com.example.api.endpoint.ApiService
import com.example.api.model.AdResponse
import retrofit2.Retrofit

class RetrofitSdkApiImpl(retrofit: Retrofit): SdkApi {

    private val apiService = retrofit.create(ApiService::class.java)

    override suspend fun loadAd(clientId: String): AdResponse = apiService.getAd()

    override suspend fun track(url: String, header: String) {
        apiService.track(url, header)
    }
}