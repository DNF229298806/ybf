package com.example.basekt.base

import android.view.View
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.ToastUtils

/**
 * @author 20888
 * @date 2019/5/29 14:37
 */
class BaseLoginViewModel : BaseActivityViewModel<BaseLoginActivity, Any>() {
    fun onLoginClick(view: View) {
        with(activityCallback.activity) {
            if (KeyboardUtils.isSoftInputVisible(this)) {
                KeyboardUtils.hideSoftInput(view)
            }
            ToastUtils.showLong("走了走了")
            ToastUtils.showLong(
                "userName:${binding.mobileEdit?.text?.get()}  " +
                        " password:${binding.passwordEdit?.text?.get()}"
            )
        }
    }

    fun onForgetPasswordClick(view: View) {
        ToastUtils.showLong("忘记密码界面")
    }

    fun onQQClick(view: View) {
        ToastUtils.showLong("QQ")
    }

    fun onWeChatClick(view: View) {
        ToastUtils.showLong("微信")
    }

    fun onSinaClick(view: View) {
        ToastUtils.showLong("新浪")
    }
}