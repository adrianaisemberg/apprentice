@file:Suppress("FunctionName")

package com.adrianaisemberg.apprentice.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.schedule

fun async(block: suspend CoroutineScope.() -> Unit) = CoroutineScope(Dispatchers.Default).launch(block = block)
fun async_io(block: suspend CoroutineScope.() -> Unit) = CoroutineScope(Dispatchers.IO).launch(block = block)
fun async_ui(block: suspend CoroutineScope.() -> Unit) = CoroutineScope(Dispatchers.Main).launch(block = block)

fun schedule(delay: Long, action: Action) = Timer("Timer").schedule(delay) {
    action.invoke()
}
