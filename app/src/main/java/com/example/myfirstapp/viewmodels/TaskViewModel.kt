package com.example.myfirstapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.data.DBService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskViewModel(private val dbService: DBService<Task>) : ViewModel() {
    private val _selectedTask = MutableLiveData<Task>()
    val selectedTask: LiveData<Task>
        get() { return _selectedTask }

    // Make accessing the current Task to be counted "globally" accessible
    fun selectTask(task: Task) {
        _selectedTask.value = task
    }

    /**
     * Launching a new coroutine to interact w/ data
     */
    fun getTasks(): LiveData<List<Task>> = dbService.getAll()
    fun insert(task: Task) = viewModelScope.launch(Dispatchers.IO) { dbService.insert(task) }
    fun delete(task: Task) = viewModelScope.launch(Dispatchers.IO) { dbService.delete(task) }

}