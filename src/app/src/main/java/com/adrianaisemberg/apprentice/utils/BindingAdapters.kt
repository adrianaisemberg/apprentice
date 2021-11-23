package com.adrianaisemberg.apprentice.utils

import android.graphics.Color
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("backgroundColorString")
fun View.backgroundColorString(colorString: String?) {
    if (colorString == null) return

    this.setBackgroundColor(Color.parseColor(colorString))
}

@BindingAdapter("onTextChanged")
fun EditText.onTextChanged(listener: OnTextChangedListener) {
    this.addTextChangedListener {
        listener.onTextChanged(it.toString())
    }
}

interface OnTextChangedListener {
    fun onTextChanged(text: String)
}

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String?) {
    if (url == null) return

    Glide.with(this)
        .load(url)
        .centerCrop()
        .into(this)
}
