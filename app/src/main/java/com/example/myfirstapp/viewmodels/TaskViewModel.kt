package com.example.myfirstapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.data.DataAccessObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskViewModel(private val dao: DataAccessObject<Task>) : ViewModel() {
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

    fun getTasks(): List<Task> = runBlocking { dao.getAll() }
    fun insert(vararg element: Task) = viewModelScope.launch(Dispatchers.IO) { dao.insert(*element) }
    fun delete(vararg element: Task) = viewModelScope.launch(Dispatchers.IO) { dao.delete(*element) }
    fun update(vararg element: Task) = viewModelScope.launch(Dispatchers.IO) { dao.update(*element) }

}