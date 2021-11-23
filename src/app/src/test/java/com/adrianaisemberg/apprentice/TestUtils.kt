package com.adrianaisemberg.apprentice

import com.adrianaisemberg.apprentice.service.ImageResult
import com.adrianaisemberg.apprentice.service.ImageUris

fun createEmptyImageResult() = ImageResult(
    id = 0,
    width = 0,
    height = 0,
    url = "",
    photographer = "",
    photographerUrl = "",
    photographerId = 0,
    averageColor = "",
    liked = false,
    src = ImageUris("", "", "", "", "", "", "", ""),
)
