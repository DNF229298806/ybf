package com.example.basekt

import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.ListCompositeDisposable

/**
 * @author 20888
 * @date 2019/5/14 11:45
 */

fun ListCompositeDisposable.add(d: Disposable) {
    this.add(d)
}

fun ListCompositeDisposable.clearDisposable() {
    if (!this.isDisposed) {
        this.clear()
    }
}
