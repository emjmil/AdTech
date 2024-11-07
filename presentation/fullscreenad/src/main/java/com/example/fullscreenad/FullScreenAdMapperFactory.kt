package com.example.fullscreenad

class FullScreenAdMapperFactory {
    fun create(executor: FullScreenAdExecutor) = FullScreenAdMapper(
        actionBuilder = FullScreenAdActionBuilder(
            executor = executor
        )
    )

}