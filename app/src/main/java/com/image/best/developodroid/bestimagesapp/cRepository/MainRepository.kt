package com.image.best.developodroid.bestimagesapp.cRepository

import android.arch.lifecycle.LiveData
import com.image.best.developodroid.bestimagesapp.dDatabase.MainDatabase
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.MainObject
import com.image.best.developodroid.bestimagesapp.dRemoteData.networkconfiguration.RetrofitObj
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import javax.inject.Inject


class MainRepository @Inject constructor(database: MainDatabase, retrofit: RetrofitObj) {

    private var mMainDao = database.mainDao()
    private var mRetrofitObj = retrofit

    fun getAllMainObj(): LiveData<List<MainObject>> = mMainDao.allMainObj

    fun searchNetwork(page:Int,search : String ){
          mRetrofitObj.api.search(page,search)
                .subscribeOn(Schedulers.io())
                .subscribe{it -> insertMainObj(it)}

    }

    private fun insertMainObj(mainObject: MainObject){

        mMainDao.insert(mainObject)

    }


}