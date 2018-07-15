package com.image.best.developodroid.bestimagesapp.utils.dagger

import com.image.best.developodroid.bestimagesapp.bViewModels.MainViewModelFactory
import com.image.best.developodroid.bestimagesapp.cRepository.MainRepository
import dagger.Module
import dagger.Provides

@Module
class FirstModule {


    @FirstScope
    @Provides
    fun providesMainViewModelFactory(mainRepository: MainRepository) : MainViewModelFactory{

        return MainViewModelFactory(mainRepository)
    }
}