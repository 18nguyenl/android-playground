package com.example.myfirstapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.services.AppDatabase
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.services.DBService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskViewModel(application: Application
                    //, private val dbService: DBService<Task>
) : ViewModel() {

    private val dbService: DBService<Task> =  AppDatabase.getDatabase(application).taskDao()

    /**
     * Launching a new coroutine to interact w/ data
     */
    fun getTasks(): Array<Task> = runBlocking { dbService.getAll() }
    fun insert(task: Task) = viewModelScope.launch(Dispatchers.IO) { dbService.insert(task) }
    fun delete(task: Task) = viewModelScope.launch(Dispatchers.IO) { dbService.delete(task) }

}

class TaskViewModelFactory(private val dbService: DBService<Task>) : ViewModelProvider.NewInstanceFactory() {

//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return TaskViewModel(application, dbService) as T
//    }

}