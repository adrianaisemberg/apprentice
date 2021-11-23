package com.adrianaisemberg.apprentice.mvvm

import android.app.Activity
import android.os.Bundle
import com.adrianaisemberg.apprentice.navigation.NavigationKey
import com.adrianaisemberg.apprentice.navigation.getString

abstract class ActivityViewModel(protected val activity: Activity) {
    open fun onCreate(savedInstanceState: Bundle?) {}

    private val arguments: Bundle?
        get() = activity.intent.extras

    protected fun getString(key: NavigationKey): String? = arguments?.getString(key)
}
