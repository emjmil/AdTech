package com.example.domain

class LoadDataUseCase(private val repository: DataRepository) {
    suspend operator fun invoke(clientId: String) = repository.load(clientId)
}