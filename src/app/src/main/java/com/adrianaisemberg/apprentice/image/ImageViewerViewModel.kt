package com.adrianaisemberg.apprentice.image

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.adrianaisemberg.apprentice.mvvm.ActivityViewModel
import com.adrianaisemberg.apprentice.navigation.NavigationKey

class ImageViewerViewModel(activity: Activity) : ActivityViewModel(activity) {

    var imageUrl = MutableLiveData("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.imageUrl.value = getString(NavigationKey.ImageUrl) ?: return
    }

}
