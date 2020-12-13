package com.tom.enhanceit.core

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.tom.enhanceit.R
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {

    protected val disposable = CompositeDisposable()

    fun showSnackBarError(view: View, error: Error, action: View.OnClickListener) {
        Snackbar.make(view, error.message, Snackbar.LENGTH_SHORT)
            .setAction(R.string.try_again, action)
            .show()

    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }
}