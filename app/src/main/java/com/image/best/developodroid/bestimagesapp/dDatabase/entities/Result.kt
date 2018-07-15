package com.image.best.developodroid.bestimagesapp.dDatabase.entities

import android.arch.persistence.room.TypeConverter
import java.util.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Result {

    var id: String? = null
    var created_at: String? = null
    var updated_at: String? = null
    var width: Int = 0
    var height: Int = 0
    var color: String? = null
    var description: Any? = null
    var urls: Urls? = null
    var links: Links? = null
    var categories: List<Any>? = null
    var isSponsored: Boolean = false
    var likes: Int = 0
    var isLiked_by_user: Boolean = false
    var current_user_collections: List<Any>? = null
    var slug: Any? = null
    var user: User? = null
    var tags: List<Tag>? = null
    var photo_tags: List<Photo_tag>? = null

}

