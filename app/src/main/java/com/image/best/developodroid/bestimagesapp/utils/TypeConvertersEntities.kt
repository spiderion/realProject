package com.image.best.developodroid.bestimagesapp.utils

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.Result
import java.util.*

class TypeConvertersEntities {
    var gson = Gson()

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return (date?.time)!!.toLong()
    }

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Result> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Result>>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Result>): String {
        return gson.toJson(someObjects)
    }
}