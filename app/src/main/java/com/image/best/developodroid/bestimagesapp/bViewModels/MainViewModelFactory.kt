package com.image.best.developodroid.bestimagesapp.bViewModels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.image.best.developodroid.bestimagesapp.cRepository.MainRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val mainRepository: MainRepository) : ViewModelProvider.Factory {

    companion object {
        private const val TAG = "MainViewModelFactory"
    }
   //Due to method definitions in ViewModelProvider.Factory
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainObjViewModel::class.java)) {
            return MainObjViewModel(mainRepository) as T
        }

        throw IllegalArgumentException("Unknown class")
    }
}