package com.adrianaisemberg.apprentice.navigation

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.adrianaisemberg.apprentice.image.ImageViewerActivity

/**
 * navigation contracts
 */
class NavigationContracts {

    /**
     * a contract for opening an image-viewer
     */
    class ImageViewerContract : ActivityResultContract<String, Nothing>() {
        /**
         * creates the contract intent, passing the image-url as the input
         *
         * @param input the image-url
         * @return an intent for opening the image-viewer activity
         */
        override fun createIntent(context: Context, input: String) =
            Intent(context, ImageViewerActivity::class.java).apply {
                putString(NavigationKey.ImageUrl, input)
            }

        /**
         * this contract doesn't provide a result
         *
         * @return nothing
         */
        override fun parseResult(resultCode: Int, intent: Intent?) = null
    }
}