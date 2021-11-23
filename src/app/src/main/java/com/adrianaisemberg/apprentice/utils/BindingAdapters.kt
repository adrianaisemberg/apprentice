package com.adrianaisemberg.apprentice.utils

import android.graphics.Color
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL

/**
 * binding adapter for setting a background color as a hex string
 *
 * @param colorString the hex color string
 */
@BindingAdapter("backgroundColorString")
fun View.backgroundColorString(colorString: String?) {
    if (colorString == null) return

    this.setBackgroundColor(Color.parseColor(colorString))
}

/**
 * binding adapter for setting a simple text-changed listener
 *
 * @param listener the text-changed listener
 */
@BindingAdapter("onTextChanged")
fun EditText.onTextChanged(listener: OnTextChangedListener) {
    this.addTextChangedListener {
        listener.onTextChanged(it.toString())
    }
}

interface OnTextChangedListener {
    fun onTextChanged(text: String)
}

/**
 * binding adapter for loading an image using the Glide library
 *
 * @param url the image url
 */
@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String?) {
    if (url == null) return

    Glide.with(this)
        .load(url)
        .centerCrop()
        .into(this)
}

/**
 * binding adapter for loading an image into a touch-enabled image-view using the Glide library
 *
 * @param url the image url
 */
@BindingAdapter("imageUrlWithTouch")
fun ImageView.imageUrlWithTouch(url: String?) {
    if (url == null) return

    Glide.with(this)
        .load(url)
        .centerCrop()

        // override the size so the image can be displayed prior to touching it
        .override(SIZE_ORIGINAL, SIZE_ORIGINAL)
        .into(this)
}

/**
 * binding adapter for fading in/out a view
 *
 * @param visible whether the view should be visible or not
 */
@BindingAdapter("visibleOrGoneWithFading")
fun View.visibleOrGoneWithFading(visible: Boolean) {
    if (visible) {
        visibility = View.VISIBLE
        fadeIn()
    } else {
        fadeOut { visibility = View.GONE }
    }
}

