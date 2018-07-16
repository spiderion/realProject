package com.image.best.developodroid.bestimagesapp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.image.best.developodroid.bestimagesapp.dDatabase.MainDatabase
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.MainObject
import com.image.best.developodroid.bestimagesapp.dDatabase.entities.Result
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainDaoTest {

    private lateinit var database: MainDatabase
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun init(){

        database = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                MainDatabase::class.java).allowMainThreadQueries()
                .build()

    }
    @After
    fun closeDb(){
        database.close()
    }


    @Test fun listOfMainObjIsEmptyWhenNoObjectInserted(){

        val mainObject = database.mainDao().allMainObj.blockingObserver()

        assertTrue(mainObject!!.isEmpty() )
    }


    @Test fun listOfMainObjMatchObjectInserted(){

        val mainObject  = MainObject()
        mainObject.results = ArrayList<Result>()
        mainObject.total=32
        mainObject.total_pages=23

        database.mainDao().insert(mainObject)
        val mainObjects = database.mainDao().allMainObj.blockingObserver()

        assertEquals(mainObjects!![0], mainObject)

    }

    @Test fun whenDeleteCalledAllObjAreDeleted(){

        val mainObject  = MainObject()
        mainObject.results = ArrayList()
        mainObject.total=32
        mainObject.total_pages=23

        database.mainDao().insert(mainObject)

        database.mainDao().deleteAll()

        val mainObjects = database.mainDao().allMainObj.blockingObserver()

        assertTrue(mainObjects!!.isEmpty())

    }


}
