package com.adrianaisemberg.apprentice.navigation

import android.app.Activity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    @Provides
    fun provideNavigation(activity: Activity): Navigation = NavigationImpl(activity)
}
