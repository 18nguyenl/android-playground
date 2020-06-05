package com.example.myfirstapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskDao: TaskDao = AppDatabase.getDatabase(application).taskDao()
    private var tasks: Array<Task> = runBlocking {
        taskDao.getAll()
    }

    fun getTasks(): Array<Task> {
        tasks = runBlocking { taskDao.getAll() }
        return tasks
    }

//    fun getTask(): Task? {
//        return task
//    }

//    fun setTask(task: Task) {
//        this.task = task
//    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        taskDao.insertAll(task)
    }
}