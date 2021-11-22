package com.adrianaisemberg.apprentice.utils

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.*
import kotlin.concurrent.schedule

interface TimerThrottler {
    fun runAfter(delay: Long, action: Action)
}

class TimerThrottlerImpl : TimerThrottler {

    private var timer: Timer? = null

    override fun runAfter(delay: Long, action: Action) {
        timer?.cancel()
        timer = Timer()
        timer?.schedule(delay) {
            action.invoke()
        }
    }
}

@Module
@InstallIn(SingletonComponent::class)
object TimerThrottlerModule {

    @Provides
    fun provideTimerThrottler(): TimerThrottler = TimerThrottlerImpl()
}
