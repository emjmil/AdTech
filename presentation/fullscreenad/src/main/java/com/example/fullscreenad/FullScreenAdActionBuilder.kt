package com.example.fullscreenad

import com.example.fullscreenad.model.Action

class FullScreenAdActionBuilder(
    val executor: FullScreenAdExecutor,
) {

    fun close(): Action = CloseAction(executor)
    fun open(): Action = OpenAction(executor)
    fun shown(): Action = ShownAction(executor)
}

data class OpenAction(val executor: FullScreenAdExecutor): Action() {
    override val execute = { executor.openAd() }
}

data class CloseAction(val executor: FullScreenAdExecutor): Action() {
    override val execute = { executor.closeAd() }
}

data class ShownAction(val executor: FullScreenAdExecutor): Action() {
    override val execute = { executor.showAd() }
}