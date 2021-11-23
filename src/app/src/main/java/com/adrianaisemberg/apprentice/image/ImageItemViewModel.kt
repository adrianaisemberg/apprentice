package com.adrianaisemberg.apprentice.image

import android.view.View
import com.adrianaisemberg.apprentice.navigation.Navigation
import com.adrianaisemberg.apprentice.service.ImageResult

class ImageItemViewModel(
    val imageResult: ImageResult,
    private val navigation: Navigation,
) {
    fun onClick(view: View) {
        navigation.openImage(imageResult)
    }
}
