package com.example.basekt.widgets

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.view.View

/**
 * @author 20888
 * @date 2019/4/13 16:32
 * 用于控制手机输入框
 */
open class MobileEditText {
    /**
     * 弱引用持有 防止泄露
     */
    val text = ObservableField<String>("")
    val showDelete = ObservableBoolean(false)

    fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
        showDelete.set(charSequence.isNotEmpty())
    }

    /**
     * 当有焦点 而且输入框不为空的时候可以显示
     */
    fun onFocusChange(v: View, hasFocus: Boolean) {
        showDelete.set(hasFocus && text.get()?.isNotEmpty() == true)
    }

    fun onDeleteClick(view: View) {
        text.set("")
    }
}
