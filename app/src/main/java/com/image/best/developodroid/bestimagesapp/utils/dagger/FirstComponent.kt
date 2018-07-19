package com.image.best.developodroid.bestimagesapp.utils.dagger

import com.image.best.developodroid.bestimagesapp.aActivities.FirstActivity
import com.image.best.developodroid.bestimagesapp.aActivities.fragments.ImageListFragment
import dagger.Subcomponent

@FirstScope
@Subcomponent(modules = [FirstModule::class])
interface FirstComponent {

    fun inject(firstActivity: FirstActivity)
    fun inject(imageListFragment: ImageListFragment)

    @Subcomponent.Builder
    interface Builder {
        fun firstModule(firstModule: FirstModule): Builder

        fun build(): FirstComponent
    }
}