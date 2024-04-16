package com.example.tasktracker


import TaskDatabase
import android.app.Application


class TaskApplication :Application() {
    val database: TaskDatabase by lazy {TaskDatabase.getInstance(this)}


}