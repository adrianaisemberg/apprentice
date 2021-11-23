package com.adrianaisemberg.apprentice.service

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * builds a retrofit client
 */
interface RetrofitBuilder {
    fun build(): Retrofit
}

class RetrofitBuilderImpl : RetrofitBuilder {

    override fun build(): Retrofit {
        val client = OkHttpClient
            .Builder()

            // adds an http logger so all requests and their responses are logged to the console
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })

            // adds a network interceptor which adds the authorization header to all calls
            .addNetworkInterceptor { chain ->
                val requestBuilder = chain.request()
                    .newBuilder()
                    .header(AUTHORIZATION, API_KEY)
                chain.proceed(requestBuilder.build())
            }
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    companion object {
        /**
         * The authorization header key
         */
        private const val AUTHORIZATION = "Authorization"

        /**
         * Apprentice's Pexels API key
         */
        private const val API_KEY = "563492ad6f91700001000001cf90ff95995f419da77b43146fa201e6"

        /**
         * Pexel's API URL
         */
        private const val URL = "https://api.pexels.com"
    }
}
