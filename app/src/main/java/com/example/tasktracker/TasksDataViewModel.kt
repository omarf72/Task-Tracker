package com.example.tasktracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksDataViewModel(private val taskInfoDao: TaskInfoDao) : ViewModel() {

    fun addTask(taskID: Int, task: String, dueDate: String, hours: Int, people: String, location: String, notes: String, urgency: Boolean){
        viewModelScope.launch {
            val newTask = Task(taskID+1; task; dueDate; hours; people; location; notes; urgency)
            taskInfoDao.insert(newTask)
        }
    }

}