package com.image.best.developodroid.bestimagesapp.utils

import android.app.Application
import com.image.best.developodroid.bestimagesapp.utils.dagger.AndroidModule
import com.image.best.developodroid.bestimagesapp.utils.dagger.AppComponent
import com.image.best.developodroid.bestimagesapp.utils.dagger.DaggerAppComponent

class App : Application() {

   lateinit var component : AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .androidModule(AndroidModule(this))
                .build()

    }
}