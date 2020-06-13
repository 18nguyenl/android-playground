package com.example.myfirstapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.data.DataAccessObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskViewModel(private val dao: DataAccessObject<Task>) : ViewModel() {

    /**
     * Launching a new coroutine to interact w/ data
     */
    fun getTasks(): List<Task> = runBlocking { dao.getAll() }
    fun insert(task: Task) = viewModelScope.launch(Dispatchers.IO) { dao.insert(task) }
    fun delete(task: Task) = viewModelScope.launch(Dispatchers.IO) { dao.delete(task) }

}