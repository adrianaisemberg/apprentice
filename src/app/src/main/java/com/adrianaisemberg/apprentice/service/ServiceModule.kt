package com.adrianaisemberg.apprentice.service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun provideAPIService(): API =
        RetrofitBuilderImpl().build().create(API::class.java)
}
