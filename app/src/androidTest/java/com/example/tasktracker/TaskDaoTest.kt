package com.example.tasktracker

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TaskDaoTest {
    private lateinit var taskDao: TaskInfoDao
    private lateinit var taskDatabase: TaskDatabase
    private var task = Task(1, "Final GDD Project", "5/10/24", "4"," ",
        " "," ",true)
    private var task2 = Task(2, "CSC Final Assignment", "5/10/24", "4","josh",
        "library"," ",false)

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        taskDatabase = Room.inMemoryDatabaseBuilder(context, TaskDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        taskDao = taskDatabase.taskInfoDao()
    }
    private suspend fun addOneItemToDb() {
        taskDao.insert(task)
    }

    private suspend fun addTwoItemsToDb() {
        taskDao.insert(task)
        taskDao.insert(task2)
    }

    @Test
    @Throws(Exception::class)
    fun daoInsert_insertsItemIntoDB() = runBlocking {
        addOneItemToDb()
        val allItems = taskDao.getTask().first()
        assertEquals(allItems[0], task)


    }
    @Test
    @Throws(Exception::class)
    fun daoGetAllItems_returnsAllItemsFromDB() = runBlocking {
        addTwoItemsToDb()
        val allItems = taskDao.getTask().first()
        val sortedItems = allItems.sortedWith(compareBy { it.taskId })

        assertEquals(sortedItems[0], task)
        assertEquals(sortedItems[1], task2)
    }
    @After
    @Throws(IOException::class)
    fun closeDb() {
        taskDatabase.close()
    }
}