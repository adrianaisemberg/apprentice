package com.adrianaisemberg.apprentice

import com.adrianaisemberg.apprentice.service.ImageResult
import com.adrianaisemberg.apprentice.service.ImageUris
import com.adrianaisemberg.apprentice.utils.Action
import com.adrianaisemberg.apprentice.utils.TimerThrottler

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

fun createInstantTimer(): TimerThrottler = object : TimerThrottler {
    override fun runAfter(delay: Long, action: Action) {
        action.invoke()
    }
}