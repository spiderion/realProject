package com.image.best.developodroid.bestimagesapp.aActivities.first


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.image.best.developodroid.bestimagesapp.R
import com.image.best.developodroid.bestimagesapp.bViewModels.MainObjViewModel
import com.image.best.developodroid.bestimagesapp.bViewModels.MainViewModelFactory
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.MainObject
import com.image.best.developodroid.bestimagesapp.dRemoteData.networkconfiguration.RetrofitObj
import com.image.best.developodroid.bestimagesapp.utils.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_first.*
import javax.inject.Inject

class FirstActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    lateinit var adapterRecyclerView: AdapterRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        window.setBackgroundDrawable(null)
        (application as App).component.firstComponentBuilder().build().inject(this)

        adapterRecyclerView = AdapterRecyclerView()
        recyclerViewMain.layoutManager = LinearLayoutManager(this)
        recyclerViewMain.adapter = adapterRecyclerView
        val mainViewModel = ViewModelProviders.of(this,mainViewModelFactory).get(MainObjViewModel::class.java)
        mainViewModel.search(4,"girls love ")
        mainViewModel.allMainObjs.observe(this, Observer { it ->  adapterRecyclerView.setMainObj(it?.get(0))})
        Log.e("hello","hello")

    }
}
