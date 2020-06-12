package com.example.myfirstapp.utilities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.services.DBService
import com.example.myfirstapp.viewmodels.TaskViewModel

class TaskViewModelFactory(private val repo: DBService<Task>): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = TaskViewModel(repo) as T

}