package com.fortatic.apps.kotlinflix.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun imageUrl(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(imageView)
            .load(it)
            .into(imageView)
    }
}