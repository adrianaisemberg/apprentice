package com.adrianaisemberg.apprentice

import android.app.Activity
import com.adrianaisemberg.apprentice.service.API
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
    ): MainActivityViewModel =
        MainActivityViewModel(
            activity = activity,
            api = api,
        )
}