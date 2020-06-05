package com.example.myfirstapp.services

import android.app.Application
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.myfirstapp.models.Task

interface DBService<T> {

    suspend fun insert(vararg elements: T)
    suspend fun delete(element: T)
    suspend fun getAll(): Array<T>
    suspend fun getByIDs(taskIds: IntArray): Array<T>
    suspend fun getByQuery(query: SimpleSQLiteQuery): Array<T>

}

// REDUNDANT WITH TASKDAO.KT; SHOULD BE DELETED IF TASKDAO IS BEING USED
//      DELETE IF NOT NECESSARY!!!!!
class TaskDBService(application: Application) : DBService<Task>{

    private val taskDao: TaskDao = AppDatabase.getDatabase(
        application
    ).taskDao()

    override suspend fun insert(vararg elements: Task){taskDao.insert(*elements)} // why the asterisk????
    override suspend fun delete(element: Task){taskDao.delete(element)}
    override suspend fun getAll(): Array<Task> = taskDao.getAll()
    override suspend fun getByIDs(taskIds: IntArray): Array<Task> = taskDao.getByIDs(taskIds)
    override suspend fun getByQuery(query: SimpleSQLiteQuery): Array<Task> = taskDao.getByQuery(query)

}