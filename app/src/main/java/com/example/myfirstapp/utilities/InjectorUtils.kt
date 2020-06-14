package com.example.myfirstapp.utilities

import android.content.Context
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.data.AppDatabase
import com.example.myfirstapp.data.DataAccessObject
import com.example.myfirstapp.viewmodels.TaskViewModelFactory

object InjectorUtils {

    private fun getTaskRepository(context: Context): DataAccessObject<Task> = AppDatabase.getDatabase(context.applicationContext).taskDao()

    fun provideTaskViewModelFactory(context: Context): TaskViewModelFactory = TaskViewModelFactory(getTaskRepository(context))

}