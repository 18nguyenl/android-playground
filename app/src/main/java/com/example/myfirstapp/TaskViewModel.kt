package com.example.myfirstapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskDao: TaskDao
    private var tasks: List<Task?>

    init {
        taskDao = AppDatabase.getDatabase(application).taskDao()
        tasks = taskDao.getAll()
    }

    fun getTasks(): List<Task?> {
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