package com.adrianaisemberg.apprentice.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("/v1/search")
    fun searchImages(
        @Query("query") query: String,
        @Query("per_page") perPage: Int,
    ): Call<ImageSearchResults>
}