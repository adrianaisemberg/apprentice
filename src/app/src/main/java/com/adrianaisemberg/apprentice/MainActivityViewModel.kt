package com.adrianaisemberg.apprentice

import android.app.Activity
import com.adrianaisemberg.apprentice.image.ImagesRecyclerAdapter
import com.adrianaisemberg.apprentice.mvvm.ActivityViewModel
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.utils.OnTextChangedListener
import com.adrianaisemberg.apprentice.utils.TimerThrottler

class MainActivityViewModel(
    activity: Activity,
    api: API,
    private val timer: TimerThrottler,
) : ActivityViewModel(activity),
    OnTextChangedListener {

    var adapter = ImagesRecyclerAdapter(api)

    override fun onTextChanged(text: String) {
        timer.runAfter(500) {
            adapter.search(text)
        }
    }
}