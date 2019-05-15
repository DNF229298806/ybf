package com.example.basekt.callback;

/**
 * ViewModel中获取Fragment对象
 *
 * @author Lznby
 */
public interface GetFragmentCallback<T> {
    /**
     * 回调获取Activity
     *
     * @return Fragment
     */
    T getFragment();
}
