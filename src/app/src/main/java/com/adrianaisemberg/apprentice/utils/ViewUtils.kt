package com.adrianaisemberg.apprentice.utils

import android.app.Activity
import android.content.ContextWrapper
import android.view.View

/**
 * returns the activity containing this view
 */
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

/**
 * fades-in the specified view
 *
 * @param duration duration of the animation
 * @param onEnd an action to run once the animation ends
 */
fun View.fadeIn(duration: Long = 300, onEnd: Action? = null) {
    animate()
        .alpha(1F)
        .setDuration(duration)
        .withEndAction(onEnd)
        .start()
}

/**
 * fades-out the specified view
 *
 * @param duration duration of the animation
 * @param onEnd an action to run once the animation ends
 */
fun View.fadeOut(duration: Long = 300, onEnd: Action? = null) {
    animate()
        .alpha(0F)
        .setDuration(duration)
        .withEndAction(onEnd)
        .start()
}
