package com.example.ybframe

import android.os.Bundle
import android.os.Handler
import com.example.basekt.base.login.BaseLoginActivity
import com.example.basekt.base.login.BaseLoginViewModel
import com.hjq.umeng.Platform
import com.hjq.umeng.UmengLogin

/**
 * @author 20888
 * @date 2019/5/30 17:17
 */
class LoginActivity : BaseLoginActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.listener=object :BaseLoginViewModel.OnLoginListener{
            override fun normalLogin(phone: String, password: String) {
                loadProgressHUD.setLabel("正在登录中....").show()
                val handler = Handler()
                handler.postDelayed({
                    loadProgressHUD.dismiss()
                }, 10000)
            }

            override fun thirdPartyLogin(platform: Platform, data: UmengLogin.LoginData) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    }
}