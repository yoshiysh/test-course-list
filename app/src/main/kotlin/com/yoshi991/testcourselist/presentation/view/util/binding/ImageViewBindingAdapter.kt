package com.yoshi991.testcourselist.presentation.view.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yoshi991.testcourselist.presentation.view.util.GlideApp

@BindingAdapter("image_circle")
fun ImageView.loadCircleImage(path: String?) {
    GlideApp.with(context)
        .load(path)
        .apply {
            diskCacheStrategy(DiskCacheStrategy.DATA)
            transform(CircleCrop())
            transition(DrawableTransitionOptions.withCrossFade())
        }
        .into(this)
}
