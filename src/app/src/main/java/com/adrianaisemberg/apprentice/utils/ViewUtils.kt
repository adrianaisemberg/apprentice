package com.adrianaisemberg.apprentice.utils

import android.app.Activity
import android.content.ContextWrapper
import android.view.View

fun View.activity(): Activity? {
    var ctx = context
    while (ctx is ContextWrapper) {
        if (ctx is Activity) {
            return ctx
        }
        ctx = (context as ContextWrapper).baseContext
    }
    return null
}

fun View.fadeIn(duration: Long = 300, onEnd: Action? = null) {
    animate()
        .alpha(1F)
        .setDuration(duration)
        .withEndAction(onEnd)
        .start()
}

fun View.fadeOut(duration: Long = 300, onEnd: Action? = null) {
    animate()
        .alpha(0F)
        .setDuration(duration)
        .withEndAction(onEnd)
        .start()
}
