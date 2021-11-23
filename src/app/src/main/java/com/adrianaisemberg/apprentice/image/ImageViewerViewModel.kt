package com.adrianaisemberg.apprentice.image

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.adrianaisemberg.apprentice.mvvm.ActivityViewModel
import com.adrianaisemberg.apprentice.navigation.NavigationKey

/**
 * view-model for displaying an image
 *
 * @param activity The underlying activity
 */
class ImageViewerViewModel(activity: Activity) : ActivityViewModel(activity) {

    var imageUrl = MutableLiveData("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get the image-url from the navigation params
        this.imageUrl.value = getString(NavigationKey.ImageUrl) ?: return
    }

    /**
     * go back by closing this activity
     */
    fun onBack() {
        activity.finish()
    }
}
