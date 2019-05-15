package com.example.basekt.base

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.basekt.R
import com.example.basekt.clearDisposable
import com.example.basekt.databinding.BaseLoginLayoutBinding
import io.reactivex.internal.disposables.ListCompositeDisposable

/**
 * @author 20888
 * @date 2019/5/15 11:22
 */
class BaseLoginActivity : AppCompatActivity() {
    val mDisposable = ListCompositeDisposable()
    val binding: BaseLoginLayoutBinding by lazy {
        DataBindingUtil.setContentView<BaseLoginLayoutBinding>(
            this,
            R.layout.base_login_layout
        )
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.clearDisposable()
    }
}