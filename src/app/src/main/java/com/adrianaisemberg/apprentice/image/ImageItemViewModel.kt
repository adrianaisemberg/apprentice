package com.adrianaisemberg.apprentice.image

import com.adrianaisemberg.apprentice.navigation.Navigation
import com.adrianaisemberg.apprentice.service.ImageResult

class ImageItemViewModel(
    val imageResult: ImageResult,
    private val navigation: Navigation,
) {
    fun onClick() {
        navigation.openImage(imageResult)
    }
}
