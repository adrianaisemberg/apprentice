package com.adrianaisemberg.apprentice.navigation

import com.adrianaisemberg.apprentice.service.ImageResult

interface Navigation {
    fun openImage(imageResult: ImageResult)
}

class NavigationImpl : Navigation {
    override fun openImage(imageResult: ImageResult) {
    }
}
