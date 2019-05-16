package com.example.basekt.widgets


import android.databinding.ObservableBoolean
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import java.lang.ref.WeakReference

/**
 * @author 20888
 * @date 2019/4/15 13:44
 * 用于控制密码输入框
 */
class PasswordEditText(editText: EditText, img: ImageView) : MobileEditText(editText) {
    //控制密码显示隐藏的眼睛
    private var img: WeakReference<ImageView> = WeakReference(img)
    var isShowPassword = ObservableBoolean(false)
    fun onShowPasswordClick(view: View) {

        /*editText.get()?.let {
            it.transformationMethod =
                if (isShowPassword) HideReturnsTransformationMethod.getInstance() else PasswordTransformationMethod.getInstance()
            it.setSelection(it.length())
        }

        img.get()?.let {
            it.setImageDrawable(ContextCompat.getDrawable(it.context,if (isShowPassword) R.mipmap.icon_cansee else R.mipmap.icon_notsee))
        }

        isShowPassword = !isShowPassword*/
    }

}
