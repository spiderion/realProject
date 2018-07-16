package com.image.best.developodroid.bestimagesapp.dRemoteData.networkconfiguration

import com.image.best.developodroid.bestimagesapp.dDatabase.entities.MainObject
import com.image.best.developodroid.bestimagesapp.utils.Constants.Companion.apiKey
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.subjects.PublishSubject
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    companion object {
        private const val TAG = "Api"
    }

    @GET("/search/photos$apiKey")
    fun search(@Query("page")page:Int,@Query("query")value:String): Observable<MainObject>
}