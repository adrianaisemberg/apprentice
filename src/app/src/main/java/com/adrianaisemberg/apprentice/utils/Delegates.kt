package com.adrianaisemberg.apprentice.utils

/**
 * a simple action delegate
 */
typealias Action = () -> Unit

/**
 * a simple generic single-parameter function delegate
 */
typealias ActionOf<T> = (t: T) -> Unit
