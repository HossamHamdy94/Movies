package com.example.movies.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("load")
fun loadImage(view: ImageView, url: String?) {

    val image_url: String = "https://image.tmdb.org/t/p/original/" +url
    image_url?.let {
        Glide.with(view).load(it).into(view)
    }


}