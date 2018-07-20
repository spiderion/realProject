package com.image.best.developodroid.bestimagesapp.dDatabase

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.MainObject
import com.image.best.developodroid.bestimagesapp.utils.TypeConvertersEntities

@Database(entities = [MainObject::class], version = 3)
@TypeConverters(TypeConvertersEntities::class)
abstract class MainDatabase : RoomDatabase() {


    abstract fun mainDao(): MainDao

    companion object {
        private const val TAG = "MainDatabase"

        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            if (INSTANCE == null) {
                synchronized(MainDatabase::class.java) {
                    if (INSTANCE == null) {

                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                MainDatabase::class.java, "MainDataBase")
                                .addCallback(sRoomdataBaseCallback)
                                .fallbackToDestructiveMigration().build()
                    }
                }
            }
            return INSTANCE!!
        }

        private val sRoomdataBaseCallback = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // TODO do operation in database when app starts using doAsync{}
            }
        }
    }

}