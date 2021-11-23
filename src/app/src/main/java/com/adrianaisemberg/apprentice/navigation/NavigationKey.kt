package com.adrianaisemberg.apprentice.navigation

import android.content.Intent
import android.os.Bundle

enum class NavigationKey {
    ImageUrl,
}

fun Intent.putString(key: NavigationKey, value: String) = putExtra(key.name, value)
fun Bundle.getString(key: NavigationKey) = getString(key.name)
