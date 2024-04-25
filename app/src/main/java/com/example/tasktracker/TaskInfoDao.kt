package com.example.tasktracker

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import kotlinx.coroutines.flow.Flow


@Dao
interface TaskInfoDao {
    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)


    @Query("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<Task>> 

    @Query("SELECT * FROM tasks WHERE taskId = :taskId")
    fun getTaskById(taskId: Int): Flow<Task?>

    @Query("SELECT * from tasks ORDER BY taskName ASC")
    fun getTask() : Flow<List<Task>>

    @Query("DELETE FROM tasks")
    suspend fun deleteAllTasks()



}
