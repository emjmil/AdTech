package com.example.domain

class TrackDataUseCase(private val repository: DataRepository) {
    suspend operator fun invoke(url: String, header: String) = repository.tracking(url, header)
}