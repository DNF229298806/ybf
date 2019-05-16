package com.example.basekt.widgets


import android.databinding.ObservableBoolean
import android.view.View

/**
 * @author 20888
 * @date 2019/4/15 13:44
 * 用于控制密码输入框
 */
class PasswordEditText : MobileEditText() {
    var isShowPassword = ObservableBoolean(false)
    fun onShowPasswordClick(view: View) {

        isShowPassword.set(!isShowPassword.get())
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
