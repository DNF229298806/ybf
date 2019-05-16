package com.example.basekt.utils

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions
import com.example.basekt.R


/**
 * @author 20888
 * @date 2019/5/16 9:48
 */
fun RequestBuilder<Drawable>.getRequestOptions(): RequestBuilder<Drawable> {
    return apply(
        RequestOptions()
            .error(R.mipmap.icon_fail)
            .fallback(R.mipmap.icon_loading)
            .placeholder(R.mipmap.icon_car)

    )
}