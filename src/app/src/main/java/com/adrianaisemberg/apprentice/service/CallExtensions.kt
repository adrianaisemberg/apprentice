package com.adrianaisemberg.apprentice.service

import com.adrianaisemberg.apprentice.utils.ActionOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * a generic enqueue wrapper for handling responses, ignoring errors
 */
fun <T> Call<T>.enqueue(
    onResponse: ActionOf<Response<T>>,
) = enqueue(onResponse) {}

/**
 * a generic enqueue wrapper for handling responses and errors
 */
fun <T> Call<T>.enqueue(
    onResponse: ActionOf<Response<T>>,
    onFailure: ActionOf<Throwable>,
) {
    this.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            onResponse.invoke(response)
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            onFailure.invoke(t)
        }
    })
}
