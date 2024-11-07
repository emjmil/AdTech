package com.example.fullscreenad.model

data class AdsModel(
    val imageUrl: String,
    val trackingUrl: String,
    val openAction: Action,
    val closeAction: Action,
    val showAction: Action
)