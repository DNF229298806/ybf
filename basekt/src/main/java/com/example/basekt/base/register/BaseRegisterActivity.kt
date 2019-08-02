package com.example.basekt.base.register

import android.os.Bundle
import com.blankj.utilcode.util.ToastUtils
import com.example.basekt.R
import com.example.basekt.base.BaseActivity
import com.example.basekt.databinding.BaseRegisterLayoutBinding
import com.example.basekt.widgets.IToolbar

/**
 * @author 20888
 * @date 2019/6/17 11:13
 */
class BaseRegisterActivity : BaseActivity<BaseRegisterViewModel, Any, BaseRegisterLayoutBinding>() {
    override fun setLayout() = R.layout.base_register_layout


    override fun bindView(entity: Any) {

    }

    override fun getClazz(): Class<BaseRegisterViewModel> = BaseRegisterViewModel::class.java

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
                //binding.toolbar = this
            }
        }
    }

}