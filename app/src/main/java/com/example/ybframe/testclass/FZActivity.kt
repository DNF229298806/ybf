package com.example.ybframe.testclass

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.ybframe.R
import kotlinx.android.synthetic.main.activity_fz.*

/**
 * @author wyb
 * @date 2019/7/1 10:56
 */
class FZActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fz)
        var wzList = ArrayList<WZ>()
        for (i in 1..10) {
            wzList.add(WZ(i.toString()))
        }
        var list = ArrayList<MultipleItem>()
        for (i in 1..100) {
            var cp = Company(i, "阿里巴巴$i", 1000 + i, wzList)
            list.add(cp)
        }

        var adapter = MultipleItemQuickAdapter(ArrayList())
        recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recycler.adapter = adapter
        adapter.bindToRecyclerView(recycler)
        for (multipleItem in list) {
            if (multipleItem is Company) {
                adapter.addData(multipleItem)
                adapter.addData(multipleItem.list)
            }
        }
    }
}