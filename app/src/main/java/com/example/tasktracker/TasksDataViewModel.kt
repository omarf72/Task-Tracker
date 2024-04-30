package com.example.tasktracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksDataViewModel(private val taskInfoDao: TaskInfoDao) : ViewModel() {







    val allTasks: LiveData<List<Task>> = taskInfoDao.getAllTasks()

    val isUrgent = MutableLiveData<Boolean>(false)

    private val _totalHoursNeeded = MutableLiveData<Int>()
    val totalHoursNeeded: LiveData<Int>
        get() = _totalHoursNeeded

    fun addTask(task: String, dueDate: String, hours: String, people: String, location: String, notes: String, isUrgent: Boolean) {
        viewModelScope.launch {
            val newTask = getNewItemEntry(task, dueDate, hours, people, location, notes, isUrgent)
            taskInfoDao.insert(newTask)
            //calculateTotalHoursNeeded() // Update total hours after adding a task
        }
    }

    fun getAllTasksSortedByUrgency(): LiveData<List<Task>> {
        return taskInfoDao.getAllTasksSortedByUrgency()
    }


    fun getTotalHours():LiveData<Int>{
        return taskInfoDao.getTotalHoursNeeded()
    }



    fun deleteAllTasks() {
        viewModelScope.launch {
            taskInfoDao.deleteAllTasks()
        }
    }

    fun getTaskById(taskId: Int): LiveData<Task?> {
        return taskInfoDao.getTaskById(taskId).asLiveData()
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskInfoDao.delete(task)
        }
    }

    private fun insertItem(newTask:Task){
        viewModelScope.launch{
            taskInfoDao.insert(newTask)
        }

    }
    private fun getNewItemEntry(
        task:String,
        dueDate: String,
        hours: String,
        people: String,
        location: String,
        notes: String,
        isUrgent: Boolean
    ):Task{

        return(
                Task(
                    task =task,
                    dueDate =dueDate,
                    hours = hours.toString(),
                    people = people,
                    location = location,
                    notes =notes,
                    urgent = isUrgent
                ))
    }
    fun isEntryValid(taskName:String,taskDueDate:String,taskHours:String,taskUrgent:String):Boolean{
        if(taskName.isBlank()||taskDueDate.isBlank()||taskHours.isBlank()||taskUrgent.isBlank()){
            return false
        }
        return true
    }

    class TasksViewModelFactory(private val taskInfoDao: TaskInfoDao): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TasksDataViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return TasksDataViewModel(taskInfoDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }

}
