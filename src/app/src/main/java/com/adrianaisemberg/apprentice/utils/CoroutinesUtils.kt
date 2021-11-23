@file:Suppress("FunctionName")

package com.adrianaisemberg.apprentice.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * runs the specified block in a default async coroutine scope
 */
fun async(block: suspend CoroutineScope.() -> Unit) =
    CoroutineScope(Dispatchers.Default).launch(block = block)

/**
 * runs the specified block in an IO coroutine scope
 */
fun async_io(block: suspend CoroutineScope.() -> Unit) =
    CoroutineScope(Dispatchers.IO).launch(block = block)

/**
 * runs the specified block in a UI coroutine scope
 */
fun async_ui(block: suspend CoroutineScope.() -> Unit) =
    CoroutineScope(Dispatchers.Main).launch(block = block)
