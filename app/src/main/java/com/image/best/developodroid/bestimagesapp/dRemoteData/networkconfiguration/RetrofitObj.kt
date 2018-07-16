package com.image.best.developodroid.bestimagesapp.dRemoteData.networkconfiguration

import android.util.Log
import com.image.best.developodroid.bestimagesapp.utils.Constants.Companion.BASE_URL
import com.image.best.developodroid.bestimagesapp.utils.Constants.Companion.CONNECTION_TIMEOUT
import com.image.best.developodroid.bestimagesapp.utils.Constants.Companion.READ_TIMEOUT
import com.image.best.developodroid.bestimagesapp.utils.Constants.Companion.WRITE_TIMEOUT
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitObj {

        private const val TAG = "RetrofitObj"


    val api: Api
    get() {
        Log.d(TAG, "api: retrofitObj build ")

        val intr = HttpLoggingInterceptor()
        intr.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient()
                .newBuilder()
                .addInterceptor(intr)
                .writeTimeout(WRITE_TIMEOUT,TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIMEOUT,TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT,TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(Api::class.java)
    }
}