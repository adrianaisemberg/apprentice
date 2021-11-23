package com.adrianaisemberg.apprentice

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import com.adrianaisemberg.apprentice.image.ImagesRecyclerAdapter
import com.adrianaisemberg.apprentice.mvvm.ActivityViewModel
import com.adrianaisemberg.apprentice.navigation.Navigation
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.utils.OnTextChangedListener
import com.adrianaisemberg.apprentice.utils.TimerThrottler

/**
 * the main activity view-model
 */
class MainActivityViewModel(
    activity: Activity,
    api: API,
    navigation: Navigation,
    private val timer: TimerThrottler,
) : ActivityViewModel(activity),
    OnTextChangedListener {

    /**
     * the image-list adapter
     */
    var adapter = ImagesRecyclerAdapter(api, navigation)

    /**
     * whether the search-box can be cleared
     */
    var canClear = MutableLiveData(false)

    /**
     * binding object for clearing the search-box
     */
    var searchText = MutableLiveData("")

    override fun onTextChanged(text: String) {
        // can-clean non-empty text only
        canClear.value = text.isNotEmpty()

        // wait 500 ms before invoking the search
        timer.runAfter(500) {
            adapter.search(text)
        }
    }

    fun onClearSearch() {
        searchText.value = ""
    }
}