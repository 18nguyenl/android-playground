package com.example.myfirstapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.services.AppDatabase
import com.example.myfirstapp.services.TaskDao
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.services.DBService
import com.example.myfirstapp.services.TaskDBService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val dbService: DBService<Task> = TaskDBService(application)

    /**
     * Launching a new coroutine to interact w/ data
     */
    fun getTasks(): Array<Task> = runBlocking { dbService.getAll() }
    fun insert(task: Task) = viewModelScope.launch(Dispatchers.IO) { dbService.insert(task) }
    fun delete(task: Task) = viewModelScope.launch(Dispatchers.IO) { dbService.delete(task) }

}