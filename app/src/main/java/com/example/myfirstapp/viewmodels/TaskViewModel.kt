package com.example.myfirstapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.data.DBService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskViewModel(private val dbService: DBService<Task>) : ViewModel() {

    /**
     * Launching a new coroutine to interact w/ data
     */
    fun getTasks(): LiveData<List<Task>> = runBlocking { dbService.getAll() }
    fun insert(task: Task) = viewModelScope.launch(Dispatchers.IO) { dbService.insert(task) }
    fun delete(task: Task) = viewModelScope.launch(Dispatchers.IO) { dbService.delete(task) }

}