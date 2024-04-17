package com.example.tasktracker

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksDataViewModel(private val taskInfoDao: TaskInfoDao) : ViewModel() {

    val allTasks: LiveData<List<Task>> = taskInfoDao.getAllTasks()

    fun addTask(task: String, dueDate: String, hours: EditText?, people: String, location: String, notes: String, urgency: String){
            val newTask = getNewItemEntry(task,dueDate,hours,people,location,notes,urgency)
            taskInfoDao.insert(newTask)

    }

    private fun insertItem(newTask:Task){
        viewModelScope.launch{
            taskInfoDao.insert(newTask)
        }

    }
    private fun getNewItemEntry(
        task:String,
        dueDate: String,
        hours: EditText?,
        people: String,
        location: String,
        notes: String,
        urgency: String
    ):Task{
        return(
                Task(
                    task =task,
                    dueDate =dueDate,
                    hours = hours.toString(),
                    people = people,
                    location = location,
                    notes =notes,
                    urgent =urgency
                ))
    }
    fun isEntryValid(taskName:String,taskDueDate:String,taskHours:String,taskUrgent:String):Boolean{
        if(taskName.isBlank()||taskDueDate.isBlank()||taskHours.isBlank()||taskUrgent.isBlank()){
            return false
        }
        return true
    }

    class TasksViewModelFactory(private val taskInfoDao:TaskInfoDao):ViewModelProvider.Factory{
        override fun <T: ViewModel> create(modelClass: Class<T>): T{
            if(modelClass.isAssignableFrom(TasksDataViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return TasksDataViewModel(taskInfoDao)as T
            }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }

}
