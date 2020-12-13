package com.tom.enhanceit.utils

import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.tom.enhanceit.R


fun ImageView.loadImage(url: String) {
    if (url.isNotEmpty()) {
        val imageView = this
        Picasso.get().load(url)
            .networkPolicy(NetworkPolicy.OFFLINE)
            .fit()
            .placeholder(R.drawable.launch)
            .error(R.drawable.launch)
            .into(this, object : Callback {
                override fun onSuccess() {
                    Log.v("PICASSO", "Success")
                }

                override fun onError(e: Exception?) {
                }
            })
    }
}



