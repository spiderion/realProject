package com.image.best.developodroid.bestimagesapp.aAdapters

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.image.best.developodroid.bestimagesapp.R
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.MainObject
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.Result
import kotlinx.android.synthetic.main.custom_view.view.*

class AdapterRecyclerView : RecyclerView.Adapter<AdapterRecyclerView.CustomHolder>() {

    companion object {
        private const val TAG = "AdapterRecyclerView"
    }

    private var mainObject : MainObject? = null


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.custom_view, p0, false)
        return CustomHolder(v)
    }

    override fun getItemCount(): Int = mainObject?.results?.count() ?: 0

    override fun onBindViewHolder(p0: CustomHolder, p1: Int) {
        p0.bind(mainObject?.results?.get(p1))
    }

    fun setMainObj(mainObject: MainObject?){
        if(mainObject!=null)
        this.mainObject= mainObject

        notifyDataSetChanged()
    }

    class CustomHolder(view: View) : RecyclerView.ViewHolder(view){

        private var tags  : StringBuilder?=StringBuilder("")

        fun bind(item : Result?){
            with(itemView){

                for (tag in item?.tags!!){
                    tags?.append(" #${tag.title}")
                }
                tagTitleTextView.text=tags

                //user profile image
                Glide.with(profileImage.context).load(item.user?.profile_image?.large).into(profileImage)
                //main image
                Glide.with(mainImage.context).load(item.urls?.regular).into(mainImage)
                // user name
                user_name.text = item.user?.name
                // layout background color
                cardview.setCardBackgroundColor(Color.parseColor(item.color))
                // likes
                likesTextView.text= "${item.likes} likes"


            }
        }
    }
}