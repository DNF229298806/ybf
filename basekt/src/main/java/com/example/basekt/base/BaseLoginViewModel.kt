package com.example.basekt.base

import android.view.View
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.ToastUtils
import com.hjq.umeng.Platform
import com.hjq.umeng.UmengClient
import com.hjq.umeng.UmengLogin
import timber.log.Timber

/**
 * @author 20888
 * @date 2019/5/29 14:37
 */
class BaseLoginViewModel : BaseActivityViewModel<BaseLoginActivity, Any>(), UmengLogin.OnLoginListener {

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
        UmengClient.login(activityCallback.activity, Platform.QQ, this)
    }

    fun onWeChatClick(view: View) {
        ToastUtils.showLong("微信")
        UmengClient.login(activityCallback.activity, Platform.WEIXIN, this)
    }

    fun onSinaClick(view: View) {
        ToastUtils.showLong("新浪")
        UmengClient.login(activityCallback.activity, Platform.SINA, this)
    }

    override fun onSucceed(platform: Platform?, data: UmengLogin.LoginData?) {
        fun printData(platform: Platform, data: UmengLogin.LoginData) {
            Timber.d(
                """第三方渠道名称：${platform.appName}
                |昵称：${data.name}
                |性别：${data.sex}
                |头像：${data.icon}
                |id：${data.id}
                |token：${data.token}
            """.trimMargin()
            )
        }

        if (platform != null && data != null) {
            printData(platform, data)
            ToastUtils.showLong(platform.appName + "成功调起")
            when (platform) {
                Platform.WEIXIN -> {

                }

                Platform.QQ -> {
                }

                Platform.SINA -> {
                }
                else -> {

                }
            }
        }
    }

    override fun onError(platform: Platform?, t: Throwable?) {
        if (platform != null && t != null) {
            ToastUtils.showLong("第三方登录出错！$t")
        }
    }

    override fun onCancel(platform: Platform?) {
        ToastUtils.showLong("取消登录")
    }

    override fun onNotInstall(message: String) {
        ToastUtils.showLong(message)
    }
}