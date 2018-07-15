package com.image.best.developodroid.bestimagesapp.utils.dagger

import android.app.Application
import com.image.best.developodroid.bestimagesapp.cRepository.MainRepository
import com.image.best.developodroid.bestimagesapp.dDatabase.MainDatabase
import com.image.best.developodroid.bestimagesapp.dRemoteData.networkconfiguration.RetrofitObj
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application = application

    @Provides
    @Singleton
    fun providesRepository(database: MainDatabase,retrofit : RetrofitObj): MainRepository = MainRepository(database,retrofit)

    @Provides
    @Singleton
    fun providesMainDatabase():MainDatabase = MainDatabase.getDatabase(application)

    @Provides
    @Singleton
    fun providesRetrofitObj():RetrofitObj{
        return RetrofitObj
    }
}