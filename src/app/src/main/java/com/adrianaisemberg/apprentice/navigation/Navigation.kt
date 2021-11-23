package com.adrianaisemberg.apprentice.navigation

import android.app.Activity
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import com.adrianaisemberg.apprentice.service.ImageResult
import com.adrianaisemberg.apprentice.utils.ActionOf

interface Navigation {
    fun openImage(imageResult: ImageResult)
}

class NavigationImpl(private val activity: Activity) : Navigation {

    private fun <I, O> launchContract(
        input: I? = null,
        contract: ActivityResultContract<I, O>,
        onResult: ActionOf<O>? = null,
    ) {
        val registeredContract = (activity as AppCompatActivity).activityResultRegistry.register(
            contract::class.java.toString(),
            contract,
        ) { output ->
            onResult?.invoke(output)
        }

        registeredContract.launch(input)
    }

    override fun openImage(imageResult: ImageResult) {
        launchContract(
            contract = NavigationContracts.ImageViewerContract(),
            input = imageResult.src.original,
        )
    }
}
