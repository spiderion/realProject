package com.image.best.developodroid.bestimagesapp.dDatabase

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.MainObject

@Dao
interface MainDao {


    @get:Query("SELECT * from MainObject")
    val allMainObj: LiveData<List<MainObject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(mainObject: MainObject)

    @Query("DELETE FROM MainObject")
    fun deleteAll()

    @Delete
    fun deleteMainObj(mainObject: MainObject)

    @Update
    fun updateMainObj(mainObject: MainObject)
}