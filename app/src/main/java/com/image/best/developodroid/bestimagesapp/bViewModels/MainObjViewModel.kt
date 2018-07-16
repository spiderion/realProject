package com.image.best.developodroid.bestimagesapp.bViewModels


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.image.best.developodroid.bestimagesapp.cRepository.MainRepository
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.MainObject
import javax.inject.Inject

class MainObjViewModel (private val repository: MainRepository)   : ViewModel(){

    companion object {
        private const val TAG = "MainObjViewModel"
    }

    val  allMainObjs : LiveData<List<MainObject>> = repository.getAllMainObj()


    fun getMainObj(): LiveData<List<MainObject>>{
      return   repository.getAllMainObj()
    }



    fun search(page : Int , search: String ){

        repository.searchNetwork(page,search)
    }


}