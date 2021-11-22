package com.adrianaisemberg.apprentice.service

import com.google.gson.annotations.SerializedName

data class ImageSearchResults(
    @SerializedName("page")
    var page: Int,

    @SerializedName("per_page")
    var perPage: Int,

    @SerializedName("total_results")
    var totalResults: Int,

    @SerializedName("next_page")
    var nextPage: String,

    @SerializedName("photos")
    var photos: List<ImageResult>,
)

data class ImageResult(
    @SerializedName("id")
    var id: Int,

    @SerializedName("width")
    var width: Int,

    @SerializedName("height")
    var height: Int,

    @SerializedName("url")
    var url: String,

    @SerializedName("photographer")
    var photographer: String,

    @SerializedName("photographer_url")
    var photographerUrl: String,

    @SerializedName("photographer_id")
    var photographerId: Int,

    @SerializedName("avg_color")
    var averageColor: String,

    @SerializedName("liked")
    var liked: Boolean,

    @SerializedName("src")
    var src: ImageUris,
)

data class ImageUris(
    @SerializedName("original")
    var original: String,

    @SerializedName("large2x")
    var large2x: String,

    @SerializedName("large")
    var large: String,

    @SerializedName("medium")
    var medium: String,

    @SerializedName("small")
    var small: String,

    @SerializedName("portrait")
    var portrait: String,

    @SerializedName("landscape")
    var landscape: String,

    @SerializedName("tiny")
    var tiny: String,
)