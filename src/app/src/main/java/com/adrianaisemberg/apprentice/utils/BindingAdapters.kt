package com.adrianaisemberg.apprentice.utils

import android.graphics.Color
import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter

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
