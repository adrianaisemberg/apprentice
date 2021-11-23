package com.adrianaisemberg.apprentice

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import com.adrianaisemberg.apprentice.image.ImagesRecyclerAdapter
import com.adrianaisemberg.apprentice.mvvm.ActivityViewModel
import com.adrianaisemberg.apprentice.navigation.Navigation
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.utils.OnTextChangedListener
import com.adrianaisemberg.apprentice.utils.TimerThrottler

class MainActivityViewModel(
    activity: Activity,
    api: API,
    navigation: Navigation,
    private val timer: TimerThrottler,
) : ActivityViewModel(activity),
    OnTextChangedListener {

    var adapter = ImagesRecyclerAdapter(api, navigation)
    var canClear = MutableLiveData(false)
    var searchText = MutableLiveData("")

    override fun onTextChanged(text: String) {
        canClear.value = text.isNotEmpty()

        timer.runAfter(500) {
            adapter.search(text)
        }
    }

    fun onClearSearch() {
        searchText.value = ""
    }
}