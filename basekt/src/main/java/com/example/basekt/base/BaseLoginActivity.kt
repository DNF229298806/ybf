package com.example.basekt.base

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.blankj.utilcode.util.ToastUtils
import com.example.basekt.R
import com.example.basekt.clearDisposable
import com.example.basekt.databinding.BaseLoginLayoutBinding
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
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.base_login_layout)
        binding.at = this
        binding.mobileEdit = MobileEditText()
        binding.passwordEdit = PasswordEditText()
        binding.dengl.setOnClickListener {
            ToastUtils.showLong("userName:${binding.mobileEdit?.text?.get()}  " +
                    " password:${binding.passwordEdit?.text?.get()}")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.clearDisposable()
    }
}