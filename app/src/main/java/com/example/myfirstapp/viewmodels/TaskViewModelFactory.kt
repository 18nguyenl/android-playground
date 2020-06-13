package com.example.myfirstapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.data.DataAccessObject

class TaskViewModelFactory(private val dao: DataAccessObject<Task>): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = TaskViewModel(dao) as T

}