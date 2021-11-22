package com.adrianaisemberg.apprentice

import android.app.Activity
import com.adrianaisemberg.apprentice.mvvm.ActivityViewModel

class MainActivityViewModel(activity: Activity) : ActivityViewModel(activity),
    OnTextChangedListener {

    override fun onTextChanged(text: String) {
    }
}