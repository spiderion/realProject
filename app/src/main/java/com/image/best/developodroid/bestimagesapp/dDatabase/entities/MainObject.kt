package com.image.best.developodroid.bestimagesapp.dDatabase.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.image.best.developodroid.bestimagesapp.utils.TypeConvertersEntities

@Entity
data class MainObject (

    @PrimaryKey
    var primaryKeyAlwaysSame : Int = 0 ,
    var total: Int = 0,
    var total_pages: Int = 0,

    @TypeConverters(TypeConvertersEntities::class)
    var results: List<Result>? = null

    )
