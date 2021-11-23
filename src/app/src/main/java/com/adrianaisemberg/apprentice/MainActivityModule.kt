package com.adrianaisemberg.apprentice

import android.app.Activity
import com.adrianaisemberg.apprentice.navigation.Navigation
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.utils.TimerThrottler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule {

    @Provides
    fun provideMainActivityViewModel(
        activity: Activity,
        api: API,
        navigation: Navigation,
        timerThrottler: TimerThrottler,
    ): MainActivityViewModel =
        MainActivityViewModel(
            activity = activity,
            api = api,
            navigation = navigation,
            timer = timerThrottler,
        )
}
