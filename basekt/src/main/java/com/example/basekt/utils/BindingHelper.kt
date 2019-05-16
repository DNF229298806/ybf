package com.example.basekt.utils

import android.databinding.BindingAdapter
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.view.View.*
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.File

/**
 * @author 20888
 * @date 2019/5/15 22:01
 */

/*@BindingAdapter("passwordDrawable")
fun setPassWordDrawable(im: ImageView, @DrawableRes drawableId: Int) {
    im.setImageDrawable(ContextCompat.getDrawable(im.context, drawableId))
}*/

@BindingAdapter("onEditFocusChange")
fun View.onFocusChange(listener: OnFocusChangeListener) {
    onFocusChangeListener = listener
}

@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) VISIBLE else GONE
}


@BindingAdapter("visibleOrIn")
fun View.setVisibleOrIn(show: Boolean) {
    visibility = if (show) VISIBLE else INVISIBLE
}

/**
 * 加载网络 或者本地图片 注意url可以为空吗？ 这边暂时设置为空
 */
@BindingAdapter("img")
fun ImageView.setImageUrl(url: String?) {
    if (Patterns.WEB_URL.matcher(url).matches()) {
        Glide.with(this).load(url).getRequestOptions().into(this)
    } else {
        val file = File(url)
        Glide.with(this).load(file).into(this)
    }
}

/**
 * 控制密码输入框的 密码是明文还是密文
 */
@BindingAdapter("transformationMethod")
fun EditText.setTransformationMethod(show: Boolean) {
    transformationMethod = if (show) HideReturnsTransformationMethod.getInstance() else PasswordTransformationMethod.getInstance()
}





