package com.adrianaisemberg.apprentice.navigation

import android.content.Intent
import android.os.Bundle

/**
 * contract navigation keys
 */
enum class NavigationKey {
    ImageUrl,
}

/**
 * puts a string into the intent bundle
 *
 * @param key the navigation-key
 * @param value the string value to be passed into the activity
 * @return the intent
 */
fun Intent.putString(key: NavigationKey, value: String) = putExtra(key.name, value)

/**
 * gets a string from the intent
 *
 * @param key the navigation-key
 * @return the passed string
 */
fun Bundle.getString(key: NavigationKey) = getString(key.name)
