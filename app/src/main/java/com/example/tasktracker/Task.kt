package com.example.tasktracker
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int = 0,
    val task: String,
    val due: String,
    val hours: Int?,
    val people: String?,
    val location: String?,
    val notes: String?,
    val urgent: Boolean
)


