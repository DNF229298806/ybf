package com.example.basekt.base;

import android.app.Activity;
import com.example.basekt.callback.GetActivityCallback;

/**
 * BaseActivityViewModel
 *
 * @author Lznby
 *
 * @param  <A> 使用到当前ViewModel的Activity
 * @param  <T> ViewModel中LiveData缺省持有的对象
 */
public class BaseActivityViewModel<A extends Activity, T> extends BaseViewModel<T>{
    /**
     * 获取Activity的回调
     */
    public GetActivityCallback<A> activityCallback;

    /**
     * 设置Activity(在Fragment中可以不用设置)
     *
     * @param activityCallback Activity
     */
    public void setActivity(GetActivityCallback<A> activityCallback) {
        this.activityCallback = activityCallback;
    }

}
