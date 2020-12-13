package com.tom.enhanceit.core

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import com.tom.enhanceit.R
import java.lang.ref.WeakReference

class Error(
    val message: String = "",
    val code: Int = 0
) {

    companion object {
        fun getError(weakContext: WeakReference<Context>, throwable: Throwable): Error {
            val context = weakContext.get()
            return when (throwable) {
                is HttpException -> Error(
                    context?.getString(R.string.generic_error)
                    ?: "",
                    throwable.code()
                )
                else -> Error(
                    context?.getString(R.string.generic_error)
                    ?: "",
                    400
                )
            }
        }
    }
}