package com.adrianaisemberg.apprentice.utils

import android.content.Context
import android.view.LayoutInflater

/**
 * creates a LayoutInflater from a given context
 *
 * @return a LayoutInflater
 */
fun Context.layoutInflater(): LayoutInflater = LayoutInflater.from(this)
