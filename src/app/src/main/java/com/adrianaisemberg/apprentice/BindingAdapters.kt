package com.adrianaisemberg.apprentice

import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter

@BindingAdapter("onTextChanged")
fun EditText.onTextChanged(listener: OnTextChangedListener) {
    this.addTextChangedListener {
        listener.onTextChanged(it.toString())
    }
}

interface OnTextChangedListener {
    fun onTextChanged(text: String)
}