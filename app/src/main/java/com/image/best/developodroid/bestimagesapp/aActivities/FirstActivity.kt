
package com.image.best.developodroid.bestimagesapp.aActivities


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.image.best.developodroid.bestimagesapp.R
import com.image.best.developodroid.bestimagesapp.aActivities.fragments.ImageListFragment
import com.image.best.developodroid.bestimagesapp.utils.App


class FirstActivity: AppCompatActivity() {

    companion object {
        private const val TAG =  "FirstActivity"
    }

    lateinit var imageListFragment: ImageListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Log.d(TAG, "onCreate: ")
        (application as App).component.firstComponentBuilder().build().inject(this)
        imageListFragment = ImageListFragment.newInstance()

        savedInstanceState?: initfFragment()
    }

   private fun initfFragment(){
       Log.d(TAG, "initfFragment: ")
        supportFragmentManager
                .beginTransaction()
                .add(R.id.firstActivityLayout,imageListFragment,"imageList")
                .commit()

    }
}
