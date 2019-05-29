package com.example.basekt.widgets

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ToastUtils

/**
 * @author 20888
 * @date 2019/5/17 13:37
 * 一个通用的分割线 适用于线性布局管理器 注意必须是垂直的
 * @param color 颜色 不传默认为R.color.colorLine
 * @param height 高度 不传默认为1dp
 * @param padding 分割线的内边距 对称的 不传默认为0dp
 * @param hasLastLine 最后一个item有没有分割线 默认false 默认没有
 * 不懂可看 https://www.jianshu.com/p/41ae13016243
 */
class LinearLayoutItemDecoration(
    @ColorRes private val color: Int = android.R.color.black, private val height: Int = 1,
    private val padding: Int = 0, private val hasLastLine: Boolean = false
) :
    RecyclerView.ItemDecoration() {
    private val paint = Paint()
    //同样是绘制内容，但与onDraw（）的区别是：绘制在图层的最上层
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }

    // 在子视图上设置绘制范围，并绘制内容
    // 绘制图层在ItemView以下，所以如果绘制区域与ItemView区域相重叠，会被遮挡
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        //给画笔加颜色
        paint.color = ContextCompat.getColor(parent.context, color)
        for (i in 0 until parent.childCount) {
            with(parent.getChildAt(i)) {
                //通过遍历得到每一个itemView 设置分割线 也就是矩形的宽度为width
                //矩形左上顶点 = itemView 左边界 下边界
                val left = left + ConvertUtils.dp2px(padding.toFloat())
                val top = bottom
                val right = right - ConvertUtils.dp2px(padding.toFloat())
                val bottom = top + ConvertUtils.dp2px(width.toFloat())
                c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
            }
        }
    }

    //设置ItemView的内嵌偏移长度（inset）
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        if (!hasLastLine && parent.getChildLayoutPosition(view) == state.itemCount - 1) {
            outRect.set(0, 0, 0, 0)
            ToastUtils.showLong("已经到了最后一个了")
        } else {
            outRect.set(0, 0, 0, ConvertUtils.dp2px(height.toFloat()))
        }
    }
}