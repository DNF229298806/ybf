package com.example.basekt.widgets

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.TextView
import com.example.basekt.R

/**
 * @author 20888
 * @date 2019/6/17 14:28
 */
class CountdownView : TextView, Runnable {
    //倒计时的时间
    private var totalTime: Int = 0
    //倒计时的当前时间
    private var currentTime = 0
    //是否重置了倒计时控件
    private var flag = false
    //记录原有文本
    private var oldText = ""

    constructor(context: Context, totalTime: Int = 60) : this(context, null, totalTime)
    constructor(context: Context, attrs: AttributeSet?, totalTime: Int = 60) : this(context, attrs, 0, totalTime)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, totalTime: Int = 60) : super(context, attrs, defStyleAttr) {
        this.totalTime = totalTime
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int, totalTime: Int = 60) : super(context, attrs, defStyleAttr, defStyleRes) {
        this.totalTime = totalTime
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        isClickable = true
    }

    override fun onDetachedFromWindow() {
        //移除延迟任务 避免内存泄露
        removeCallbacks(this)
        super.onDetachedFromWindow()
    }

    override fun performClick(): Boolean {
        val click = super.performClick()
        oldText = text.toString()
        isEnabled = false
        currentTime = totalTime
        post(this)
        return click
    }

    /**
     * 重置倒计时控件
     */
    fun resetState() {
        flag = true
    }

    override fun run() {
        //如果倒计时结束了 或者是重置了
        if (currentTime == 0 || flag) {
            text = oldText
            isEnabled = true
            flag = false
        } else {
            currentTime--
            text = currentTime.toString().plus(context.getString(R.string.second_english))
            //每秒刷新咯
            postDelayed(this, 1000)
        }
    }

}