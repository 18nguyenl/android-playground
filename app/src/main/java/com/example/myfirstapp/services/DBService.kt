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