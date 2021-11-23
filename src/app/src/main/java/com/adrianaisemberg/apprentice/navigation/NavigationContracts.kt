package com.adrianaisemberg.apprentice.navigation

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.adrianaisemberg.apprentice.image.ImageViewerActivity

class NavigationContracts {

    class ImageViewerContract : ActivityResultContract<String, Nothing>() {
        override fun createIntent(context: Context, input: String) =
            Intent(context, ImageViewerActivity::class.java).apply {
                putString(NavigationKey.ImageUrl, input)
            }

        override fun parseResult(resultCode: Int, intent: Intent?) = null
    }
}