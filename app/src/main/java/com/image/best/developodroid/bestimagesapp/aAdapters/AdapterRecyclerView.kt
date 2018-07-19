package com.image.best.developodroid.bestimagesapp.aAdapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.MainObject
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.Result
import com.image.best.developodroid.bestimagesapp.databinding.CustomViewBinding

class AdapterRecyclerView : RecyclerView.Adapter<AdapterRecyclerView.CustomHolder>() {

    companion object {
        private const val TAG = "AdapterRecyclerView"
    }

    private var mainObject: MainObject? = null


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val itemBinding = CustomViewBinding.inflate(layoutInflater, p0, false)
        return CustomHolder(itemBinding)
    }

    override fun getItemCount(): Int = mainObject?.results?.count() ?: 0

    override fun onBindViewHolder(p0: CustomHolder, p1: Int) {
        p0.bind(mainObject?.results?.get(p1))
    }

    fun setMainObj(mainObject: MainObject?) {
        if (mainObject != null)
            this.mainObject = mainObject

        notifyDataSetChanged()
    }

    class CustomHolder(private val binding: CustomViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Result?) {

            Log.d(TAG, "bind: ")

            with(itemView) {

                binding.resultLayout = item
                binding.executePendingBindings()

            }
        }
    }
}