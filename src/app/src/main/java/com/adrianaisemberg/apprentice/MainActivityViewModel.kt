package com.adrianaisemberg.apprentice

import android.app.Activity
import com.adrianaisemberg.apprentice.mvvm.ActivityViewModel
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.service.enqueue
import java.util.*
import kotlin.concurrent.schedule

class MainActivityViewModel(
    activity: Activity,
    private val api: API,
) : ActivityViewModel(activity),
    OnTextChangedListener {

    var timer: Timer? = null

    override fun onTextChanged(text: String) {
        timer?.cancel()
        timer = Timer()
        timer?.schedule(500) {
            api.searchImages(text).enqueue {
                val results = it.body()
            }
        }
    }
}