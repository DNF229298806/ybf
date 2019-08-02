package com.example.ybframe.testclass

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.ybframe.R

/**
 * @author wyb
 * @date 2019/7/1 12:56
 */
class TestAdapter(layoutResId: Int) : BaseQuickAdapter<WZ, BaseViewHolder>(layoutResId) {
    override fun convert(helper: BaseViewHolder?, item: WZ?) {
        if (helper != null && item != null) {
            helper.setText(R.id.wz_code, item.wzCode)
        }
    }
}