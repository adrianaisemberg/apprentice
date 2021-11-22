package com.adrianaisemberg.apprentice

import android.app.Activity
import com.adrianaisemberg.apprentice.image.ImagesRecyclerAdapter
import com.adrianaisemberg.apprentice.mvvm.ActivityViewModel
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.service.enqueue
import com.adrianaisemberg.apprentice.utils.OnTextChangedListener
import java.util.*
import kotlin.concurrent.schedule

class MainActivityViewModel(
    activity: Activity,
    private val api: API,
) : ActivityViewModel(activity),
    OnTextChangedListener {

    var adapter = ImagesRecyclerAdapter()

    var timer: Timer? = null

    override fun onTextChanged(text: String) {
        timer?.cancel()
        timer = Timer()
        timer?.schedule(500) {
            api.searchImages(text).enqueue {
                val results = it.body() ?: return@enqueue

                adapter.setInitialResult(results)
                adapter.notifyDataSetChanged()
                // adapter.notifyItemRangeChanged(0, results.photos.size)
            }
        }
    }
}