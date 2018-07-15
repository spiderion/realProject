package com.image.best.developodroid.bestimagesapp.utils.dagger

import com.image.best.developodroid.bestimagesapp.aActivities.first.FirstActivity
import dagger.Subcomponent

@FirstScope
@Subcomponent(modules = [FirstModule::class])
interface FirstComponent {

    fun inject(firstActivity: FirstActivity)

    @Subcomponent.Builder
     interface Builder{
        fun firstModule(firstModule: FirstModule): Builder

        fun build() : FirstComponent
    }
}