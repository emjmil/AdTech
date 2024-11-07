package com.example.api.endpoint

import com.example.api.model.AdResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Url

interface ApiService {
    @GET("test/ad.json")
     suspend fun getAd(): AdResponse

    @GET
    @Headers("Content-Type: application/json")
    suspend fun track(
        @Url url: String,
        @Header("name") header: String
    )
}