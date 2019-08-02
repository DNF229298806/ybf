package com.example.ybframe.testclass

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.ybframe.R

/**
 * @author wyb
 * @date 2019/7/1 12:40
 */
class MultipleItemQuickAdapter(data: MutableList<MultipleItem>?) : BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder>(data) {
    init {
        addItemType(HEAD, R.layout.item_head)
        addItemType(CONTENT, R.layout.item_recycler)
    }
    override fun convert(helper: BaseViewHolder?, item: MultipleItem?) {
        if (helper != null && item != null) {
            when (helper.itemViewType) {
                HEAD->{
                    if (item is Company) {
                        helper.setText(R.id.tv_bianhao, item.bianhao.toString())
                                .setText(R.id.tv_name, item.name)
                                .setText(R.id.tv_code,item.code.toString())
                    }
                }
                CONTENT->{
                    if (item is WZ) {
                        val recyclerView = helper.getView<RecyclerView>(R.id.recycler)
                        var wzAdapter = TestAdapter(R.layout.item_jiandan_list)
                        recyclerView.layoutManager = LinearLayoutManager(helper.itemView.context)
                        wzAdapter.addData(item)
                        recyclerView.adapter = wzAdapter
                    }
                }
            }
        }
    }
}