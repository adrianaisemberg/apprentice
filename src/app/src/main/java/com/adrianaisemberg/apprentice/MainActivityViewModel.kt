package com.adrianaisemberg.apprentice

import android.app.Activity
import com.adrianaisemberg.apprentice.image.ImagesRecyclerAdapter
import com.adrianaisemberg.apprentice.mvvm.ActivityViewModel
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.service.enqueue
import com.adrianaisemberg.apprentice.utils.OnTextChangedListener
import com.adrianaisemberg.apprentice.utils.TimerThrottler

class MainActivityViewModel(
    activity: Activity,
    private val api: API,
    private val timer: TimerThrottler,
) : ActivityViewModel(activity),
    OnTextChangedListener {

    var adapter = ImagesRecyclerAdapter()

    override fun onTextChanged(text: String) {
        timer.runAfter(5000) {
            api.searchImages(text).enqueue {
                val results = it.body() ?: return@enqueue
                adapter.setInitialResult(results)
                adapter.notifyDataSetChanged()
                // adapter.notifyItemRangeChanged(0, results.photos.size)
            }
        }
    }
}