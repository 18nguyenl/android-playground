package com.example.myfirstapp.services

import android.app.Application
import com.example.myfirstapp.models.Task

interface DBService<T> {

    suspend fun insert(vararg elements: T)
    suspend fun delete(element: T)
    suspend fun getAll(): Array<T>
    suspend fun getByIDs(taskIds: IntArray): Array<T>

}

class TaskDBService(application: Application) : DBService<Task>{

    private val taskDao: TaskDao = AppDatabase.getDatabase(
        application
    ).taskDao()

    override suspend fun insert(vararg elements: Task){taskDao.insertAll(elements)}
    override suspend fun delete(element: Task){taskDao.delete(element)}
    override suspend fun getAll(): Array<T> = taskDao.getAll()
    override suspend fun getByIDs(taskIds: IntArray): Array<T> = taskDao.getByIDs(taskIds)

}