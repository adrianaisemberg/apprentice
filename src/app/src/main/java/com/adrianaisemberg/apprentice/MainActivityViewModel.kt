package com.adrianaisemberg.apprentice

import android.app.Activity
import com.adrianaisemberg.apprentice.mvvm.ActivityViewModel
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.service.enqueue

class MainActivityViewModel(
    activity: Activity,
    private val api: API,
) : ActivityViewModel(activity),
    OnTextChangedListener {

    override fun onTextChanged(text: String) {
        api.searchImages(text).enqueue {
            val results = it.body()
        }
    }
}