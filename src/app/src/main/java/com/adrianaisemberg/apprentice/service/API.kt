package com.adrianaisemberg.apprentice.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * the image-search API
 *
 */
interface API {

    /**
     * GET image-search results
     *
     * @param query the search term
     * @param perPage the number of items per page
     * @param page the page index
     */
    @GET("/v1/search")
    fun searchImages(
        @Query("query") query: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
    ): Call<ImageSearchResults>
}