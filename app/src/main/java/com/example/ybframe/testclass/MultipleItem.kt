package com.example.ybframe.testclass

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * @author wyb
 * @date 2019/7/1 12:35
 */
const val HEAD = 1
const val CONTENT = 2

open class MultipleItem : MultiItemEntity {
    private var itemType: Int = 0

    constructor(itemType: Int) {
        this.itemType = itemType
    }

    override fun getItemType(): Int {
        return itemType
    }
}