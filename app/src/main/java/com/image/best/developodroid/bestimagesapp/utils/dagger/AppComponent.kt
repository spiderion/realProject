package com.image.best.developodroid.bestimagesapp.utils.dagger

import com.image.best.developodroid.bestimagesapp.cRepository.MainRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidModule::class])
interface AppComponent {


    fun firstComponentBuilder(): FirstComponent.Builder

    fun mainRepository(): MainRepository

}