package com.example.myfirstapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.data.DataAccessObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskViewModel(private val dao: DataAccessObject<Task>) : ViewModel() {

    fun getTasks(): List<Task> = runBlocking { dao.getAll() }
    fun insert(vararg element: Task) = viewModelScope.launch(Dispatchers.IO) { dao.insert(*element) }
    fun delete(vararg element: Task) = viewModelScope.launch(Dispatchers.IO) { dao.delete(*element) }
    fun update(vararg element: Task) = viewModelScope.launch(Dispatchers.IO) { dao.update(*element) }

}