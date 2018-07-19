package com.image.best.developodroid.bestimagesapp.utils

import android.annotation.SuppressLint
import android.databinding.BindingAdapter
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.v7.widget.CardView
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.Result
import java.text.SimpleDateFormat

class DataBindingAdapters {
    companion object {
        private const val TAG = "DataBindingAdapters"

        @ColorInt
      private  fun getContrastColor(@ColorInt color: Int): Int {
            // Counting the perceptive luminance - human eye favors green color...
            val checkColorContrast = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
            return if (checkColorContrast < 0.5) Color.BLACK else Color.WHITE
        }

        @BindingAdapter("imageUrlGlide")
        @JvmStatic
        fun setImageUrl(imageView: ImageView, url: String) {
            val context = imageView.context
            Glide.with(context).load(url).into(imageView)
        }

        @BindingAdapter("listTagsToString")
        @JvmStatic
        fun convertListTagsInToString(textView: TextView, list : Result) {
            Log.d(TAG, "convertListTagsInToString: ")
             val tags = StringBuilder("")

            for (tag in list.tags!!){
                tags.append(" #${tag.title}")

            }
            textView.text= tags

        }

        @SuppressLint("SimpleDateFormat")
        @BindingAdapter("timeAgo")
        @JvmStatic
        fun getTimeAgo(timeAgo : TextView, resultLayout :Result){
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

            timeAgo.text = TimeAgo.using(simpleDateFormat.parse(resultLayout.created_at).time)

        }
        @BindingAdapter("cardViewColor")
        @JvmStatic
        fun cardViewColor(cardView:  CardView, resultLayout :Result){

            cardView.setCardBackgroundColor(Color.parseColor(resultLayout.color))
        }

        @BindingAdapter("setPerceptiveColor")
        @JvmStatic
        fun setPerceptiveLuminanceContrast(typeView: TextView, resultLayout: Result){
            typeView.setTextColor(getContrastColor(Color.parseColor(resultLayout.color)))
        }
        @BindingAdapter("setPerceptiveColor")
        @JvmStatic
        fun setPerceptiveLuminanceContrast(typeView: ImageView, resultLayout: Result){
            typeView.setColorFilter(getContrastColor(Color.parseColor(resultLayout.color)))
        }
    }
}