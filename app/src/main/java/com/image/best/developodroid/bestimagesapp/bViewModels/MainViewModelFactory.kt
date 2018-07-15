package com.image.best.developodroid.bestimagesapp.bViewModels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.image.best.developodroid.bestimagesapp.cRepository.MainRepository

class MainViewModelFactory(private val mainRepository: MainRepository) : ViewModelProvider.Factory {

   //Due to method definitions in ViewModelProvider.Factory
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainObjViewModel::class.java)) {
            return MainObjViewModel(mainRepository) as T
        }

        throw IllegalArgumentException("Unknown class")
    }
}