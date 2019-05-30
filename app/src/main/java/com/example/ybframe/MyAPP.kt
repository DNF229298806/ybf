package com.example.ybframe

import com.example.basekt.base.login.hasQQ
import com.example.basekt.base.login.hasThirdParty
import com.example.basekt.base.login.hasWX
import com.example.basekt.network.configure.App

/**
 * @author 20888
 * @date 2019/5/30 10:32
 */
class MyAPP : App() {
    override fun onCreate() {
        fun initLoginConfig() {
            hasThirdParty = true
            hasQQ = true
            hasWX = true
        }
        super.onCreate()
        initLoginConfig()
    }
}