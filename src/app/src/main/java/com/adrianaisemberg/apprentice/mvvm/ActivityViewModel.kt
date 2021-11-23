package com.adrianaisemberg.apprentice.mvvm

import android.app.Activity
import android.os.Bundle
import com.adrianaisemberg.apprentice.navigation.NavigationKey
import com.adrianaisemberg.apprentice.navigation.getString

/**
 * base class for all activity view-models
 *
 * @property activity the underlying activity
 */
abstract class ActivityViewModel(protected val activity: Activity) {
    open fun onCreate(savedInstanceState: Bundle?) {}

    /**
     * gets the arguments passed to this activity
     */
    private val arguments: Bundle?
        get() = activity.intent.extras

    /**
     * reads a string from the intent arguments
     *
     * @param key the navigation-key
     * @return the string parameter
     */
    protected fun getString(key: NavigationKey): String? = arguments?.getString(key)
}
