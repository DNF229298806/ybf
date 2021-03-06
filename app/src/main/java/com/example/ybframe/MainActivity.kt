package com.example.ybframe

import android.content.Intent
import android.os.Bundle
import com.blankj.utilcode.util.ToastUtils
import com.example.basekt.base.BaseActivity
import com.example.basekt.widgets.IToolbar
import com.example.ybframe.databinding.ActivityMainBinding
import com.example.ybframe.testclass.AAAA
import com.example.ybframe.testclass.FZActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<MainViewModel, Any, ActivityMainBinding>() {
    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun bindView(entity: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getClazz(): Class<MainViewModel> {
        //相当于java的 MainViewModel.class
        return MainViewModel::class.java
    }

    override fun doOnCreate(savedInstanceState: Bundle?) {
        bt.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
        bt1.setOnClickListener { startActivity(Intent(this, AAAA::class.java)) }
        bt3.setOnClickListener { startActivity(Intent(this, FZActivity::class.java)) }
        fun initToolBar() {
            val toolbar = IToolbar()
            toolbar.title.set("中华人民共和国成立了")
            toolbar.showLeftIcon.set(false)
            toolbar.leftIconClick = IToolbar.ClickCallback { ToastUtils.showLong("123123123123") }
            toolbar.showLeftText.set(false)
            toolbar.titleTextColor.set(android.R.color.holo_blue_dark)
            toolbar.titleBackgroundColor.set(android.R.color.holo_red_light)
            binding.toolbar = toolbar
        }
        initToolBar()
    }


}
