package com.example.basekt.widgets

import android.databinding.ObservableBoolean
import android.view.View
import android.widget.EditText
import java.lang.ref.WeakReference

/**
 * @author 20888
 * @date 2019/4/13 16:32
 * 用于控制手机输入框
 */
open class MobileEditText(editText: EditText) {
    /**
     * 弱引用持有 防止泄露
     */
    var editText: WeakReference<EditText> = WeakReference(editText)
    var showDelete = ObservableBoolean(false)

    fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
        editText.get()?.let {
            showDelete.set(it.isFocusable && it.text.isNotEmpty())
        }
        //showDelete.set(editText.get()?.isFocusable ?: false && editText.get()?.text?.length ?: 0 > 0)
    }

    fun onFocusChange(v: View?, hasFocus: Boolean) {
        showDelete.set(hasFocus)
    }


    fun onDeleteClick(view: View) {
        editText.get()?.setText("")
    }
}
