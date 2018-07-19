package com.image.best.developodroid.bestimagesapp.aActivities.fragments


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.image.best.developodroid.bestimagesapp.R
import com.image.best.developodroid.bestimagesapp.aAdapters.AdapterRecyclerView
import com.image.best.developodroid.bestimagesapp.bViewModels.MainObjViewModel
import com.image.best.developodroid.bestimagesapp.bViewModels.MainViewModelFactory
import com.image.best.developodroid.bestimagesapp.databinding.FragmentImageListBinding
import com.image.best.developodroid.bestimagesapp.utils.App
import kotlinx.android.synthetic.main.fragment_image_list.*
import javax.inject.Inject


class ImageListFragment : Fragment() {
    // dataBinding
    lateinit var fragBinding: FragmentImageListBinding

    private lateinit var adapter: AdapterRecyclerView
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    companion object {
        private const val TAG = "ImageListFragment"
        @JvmStatic
        fun newInstance() = ImageListFragment()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (context?.applicationContext as App).component.firstComponentBuilder().build().inject(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView: ")

        fragBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_list, container, false)


        return fragBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = AdapterRecyclerView()
        recyclerViewMainFrag.layoutManager = LinearLayoutManager(activity)
        recyclerViewMainFrag.adapter = adapter
        recyclerViewMainFrag.setHasFixedSize(true)

        val mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainObjViewModel::class.java)
        mainViewModel.allMainObjs.observe(this, Observer { it -> adapter.setMainObj(it?.get(0)) })

    }


    override fun onDetach() {
        Log.d(TAG, "onDetach: ")
        super.onDetach()
    }

}
