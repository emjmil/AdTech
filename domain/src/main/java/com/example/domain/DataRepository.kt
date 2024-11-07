package com.example.domain

interface DataRepository {
    suspend fun load(clientId: String): Ad
    suspend fun tracking(url: String, header: String)
}