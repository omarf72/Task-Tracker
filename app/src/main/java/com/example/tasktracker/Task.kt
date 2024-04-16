package com.example.tasktracker
import android.widget.EditText
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var taskId: Int = 0,
    @ColumnInfo(name = "taskName")
    var task: String,
    @ColumnInfo(name = "dueDate")
    val dueDate: String,
    @ColumnInfo(name = "hours")
    val hours: String?,
    @ColumnInfo(name = "people")
    val people: String?,
    @ColumnInfo(name = "location")
    val location: String?,
    @ColumnInfo(name = "notes")
    val notes: String?,
    @ColumnInfo(name = "urgency")
    val urgent: String
)


