package com.example.basekt.base.login

import android.content.Intent
import android.os.Bundle
import com.blankj.utilcode.util.ToastUtils
import com.example.basekt.R
import com.example.basekt.base.BaseActivity
import com.example.basekt.databinding.BaseLoginLayoutBinding
import com.example.basekt.widgets.IToolbar
import com.example.basekt.widgets.MobileEditText
import com.example.basekt.widgets.PasswordEditText
import com.hjq.umeng.UmengClient

/**
 * @author 20888
 * @date 2019/5/15 11:22
 */
open class BaseLoginActivity : BaseActivity<BaseLoginViewModel, Any, BaseLoginLayoutBinding>() {
    override fun bindView(entity: Any) {
    }

    override fun setLayout() = R.layout.base_login_layout


    override fun getClazz(): Class<BaseLoginViewModel> {
        return BaseLoginViewModel::class.java
    }

    override fun doOnCreate(savedInstanceState: Bundle?) {
        fun initToolbar() {
            with(IToolbar()) {
                showLeftIcon.set(false)
                title.set("")
                showRightText.set(true)
                rightTextColor.set(R.color.colorAccent)
                rightText.set("注册")
                titleBackgroundColor.set(android.R.color.white)
                rightTextClick = IToolbar.ClickCallback { ToastUtils.showLong("注册一下啦") }
                binding.toolbar = this
            }
        }

        with(binding) {
            mobileEdit = MobileEditText()
            passwordEdit = PasswordEditText()
        }
        initToolbar()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // 回调友盟第三方登录 SDK 的接口
        UmengClient.onActivityResult(this, requestCode, resultCode, data)
    }
}