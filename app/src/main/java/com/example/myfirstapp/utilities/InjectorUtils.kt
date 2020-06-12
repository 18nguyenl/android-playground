package com.example.myfirstapp.utilities

import android.content.Context
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.services.AppDatabase
import com.example.myfirstapp.services.DBService

object InjectorUtils {

    private fun getTaskRepository(context: Context): DBService<Task> = AppDatabase.getDatabase(context.applicationContext).taskDao()

    fun provideTaskViewModelFactory(context: Context) = TaskViewModelFactory(getTaskRepository(context))

}