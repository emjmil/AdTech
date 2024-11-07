package com.example.fullscreenad.model

open class Action(
    open val title: String = "",
    open val icon: Int = 0,
    open val execute: () -> Unit = {}
)