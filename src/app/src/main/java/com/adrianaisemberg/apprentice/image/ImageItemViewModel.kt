package com.adrianaisemberg.apprentice.image

import com.adrianaisemberg.apprentice.navigation.Navigation
import com.adrianaisemberg.apprentice.service.ImageResult

/**
 * view-model for an image item
 *
 * @property imageResult the image search result
 * @property navigation navigation
 */
class ImageItemViewModel(
    val imageResult: ImageResult,
    private val navigation: Navigation,
) {
    fun onClick() {
        navigation.openImage(imageResult)
    }
}
