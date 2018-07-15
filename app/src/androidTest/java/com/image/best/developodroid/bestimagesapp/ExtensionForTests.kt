package com.image.best.developodroid.bestimagesapp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

fun <T> LiveData<T>.blockingObserver():T? {
    var value : T? = null
    val latch = CountDownLatch(1)
    val innerObserver = Observer<T>{
        value = it
        latch.countDown()

    }
    observeForever(innerObserver)
    latch.await(2,TimeUnit.SECONDS)
    return value
}
