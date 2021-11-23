package com.adrianaisemberg.apprentice.service

import com.google.gson.annotations.SerializedName

data class ImageSearchResults(
    /**
     * The current page number.
     */
    @SerializedName("page")
    var page: Int,

    /**
     * The number of results returned with each page.
     */
    @SerializedName("per_page")
    var perPage: Int,

    /**
     * The total number of results for the request.
     */
    @SerializedName("total_results")
    var totalResults: Int,

    /**
     * URL for the next page of results, if applicable.
     */
    @SerializedName("next_page")
    var nextPage: String,

    /**
     * An array of Photo objects.
     */
    @SerializedName("photos")
    var photos: List<ImageResult>,
)

data class ImageResult(
    /**
     * The id of the photo.
     */
    @SerializedName("id")
    var id: Int,

    /**
     * The real width of the photo in pixels.
     */
    @SerializedName("width")
    var width: Int,

    /**
     * The real height of the photo in pixels.
     */
    @SerializedName("height")
    var height: Int,

    /**
     * The Pexels URL where the photo is located.
     */
    @SerializedName("url")
    var url: String,

    /**
     * The name of the photographer who took the photo.
     */
    @SerializedName("photographer")
    var photographer: String,

    /**
     * The URL of the photographer's Pexels profile.
     */
    @SerializedName("photographer_url")
    var photographerUrl: String,

    /**
     * The id of the photographer.
     */
    @SerializedName("photographer_id")
    var photographerId: Int,

    /**
     * The average color of the photo. Useful for a placeholder while the image loads.
     */
    @SerializedName("avg_color")
    var averageColor: String,

    /**
     * Whether this image was liked or not
     */
    @SerializedName("liked")
    var liked: Boolean,

    /**
     * An assortment of different image sizes that can be used to display this Photo.
     */
    @SerializedName("src")
    var src: ImageUris,
)

data class ImageUris(
    /**
     * The image without any size changes. It will be the same as the width and height attributes.
     */
    @SerializedName("original")
    var original: String,

    /**
     * The image resized W 940px X H 650px DPR 2.
     */
    @SerializedName("large2x")
    var large2x: String,

    /**
     * The image resized to W 940px X H 650px DPR 1.
     */
    @SerializedName("large")
    var large: String,

    /**
     * The image scaled proportionally so that it's new height is 350px.
     */
    @SerializedName("medium")
    var medium: String,

    /**
     * The image scaled proportionally so that it's new height is 130px.
     */
    @SerializedName("small")
    var small: String,

    /**
     * The image cropped to W 800px X H 1200px.
     */
    @SerializedName("portrait")
    var portrait: String,

    /**
     * The image cropped to W 1200px X H 627px.
     */
    @SerializedName("landscape")
    var landscape: String,

    /**
     * The image cropped to W 280px X H 200px.
     */
    @SerializedName("tiny")
    var tiny: String,
)