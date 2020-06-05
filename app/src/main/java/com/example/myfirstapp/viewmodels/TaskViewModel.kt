package com.example.myfirstapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.services.AppDatabase
import com.example.myfirstapp.services.TaskDao
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.services.DBService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskViewModel(application: Application, private val dbService: DBService<Task>) : AndroidViewModel(application) {

    private val taskDao: TaskDao = AppDatabase.getDatabase(
        application
    ).taskDao()

    private var tasks: Array<Task> = runBlocking {
        dbService.getAll()
    }

    fun getTasks(): Array<Task> {
        tasks = runBlocking { dbService.getAll() }
        return tasks
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        dbService.insert(task)
    }
}