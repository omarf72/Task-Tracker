package com.example.tasktracker

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.lifecycle.LiveData

@Dao
interface TaskInfoDao {
    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<Task>> // Return LiveData<List<Task>>

    @Query("SELECT * FROM tasks WHERE taskId = :taskId")
    fun getTaskById(taskId: Int): LiveData<Task?> // Return LiveData<Task?>

}
