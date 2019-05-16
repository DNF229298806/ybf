package com.example.basekt.base

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.ToastUtils
import com.example.basekt.R
import com.example.basekt.clearDisposable
import com.example.basekt.databinding.BaseLoginLayoutBinding
import com.example.basekt.widgets.IToolbar
import com.example.basekt.widgets.MobileEditText
import com.example.basekt.widgets.PasswordEditText
import io.reactivex.internal.disposables.ListCompositeDisposable

/**
 * @author 20888
 * @date 2019/5/15 11:22
 */
class BaseLoginActivity : AppCompatActivity() {
    val mDisposable = ListCompositeDisposable()


    lateinit var binding: BaseLoginLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        fun initToolbar() {
            with(IToolbar()) {
                showLeftIcon.set(false)
                showLeftText.set(false)
                showRightIcon.set(false)
                title.set("")
                showRightText.set(true)
                rightTextColor.set(android.R.color.holo_blue_bright)
                rightText.set("注册")
                titleBackgroundColor.set(android.R.color.white)
                rightTextClick = IToolbar.ClickCallback { ToastUtils.showLong("注册一下啦") }
                binding.toolbar = this
            }
        }

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.base_login_layout)
        with(binding){
            at = this@BaseLoginActivity
            mobileEdit = MobileEditText()
            passwordEdit = PasswordEditText()
        }

        initToolbar()
    }


    fun onLoginClick(view: View) {
        if (KeyboardUtils.isSoftInputVisible(this)) {
            KeyboardUtils.hideSoftInput(view)
        }
        ToastUtils.showLong("走了走了")
        ToastUtils.showLong("userName:${binding.mobileEdit?.text?.get()}  " +
                " password:${binding.passwordEdit?.text?.get()}")
    }

    fun onForgetPasswordClick(view:View) {
        ToastUtils.showLong("忘记密码界面")
    }

    fun onQQClick(view:View) {
        ToastUtils.showLong("QQ")
    }

    fun onWeChatClick(view:View) {
        ToastUtils.showLong("微信")
    }

    fun onSinaClick(view: View) {
        ToastUtils.showLong("新浪")
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.clearDisposable()
    }
}