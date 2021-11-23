package com.adrianaisemberg.apprentice.navigation

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    @Provides
    fun provideNavigation(): Navigation = NavigationImpl()
}
