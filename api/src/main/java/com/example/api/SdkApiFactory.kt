package com.example.api

import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.kotlinx.serialization.asConverterFactory

const val BASE_URL = "https://voodoo-adn-framework.s3.eu-west-1.amazonaws.com/"
const val CLIENT_ID = "857ed9c3-721d-4f34-80e5-657b6cbc27ad"

fun createSdkApi(): Retrofit {
    val json = Json {
        ignoreUnknownKeys = true
    }
     return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()

}