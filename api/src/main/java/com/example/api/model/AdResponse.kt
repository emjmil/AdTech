package com.example.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AdResponse (
    @SerialName("static") val imageUrl: String,
    @SerialName("close_delay") val closeDelay: Int,
    @SerialName("tracking") val trackingUrl: String,
    @SerialName("clickthrough") val clickThrough: String
)