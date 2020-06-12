package com.example.myfirstapp.data

import androidx.sqlite.db.SimpleSQLiteQuery

interface DBService<T> {

    suspend fun insert(vararg elements: T)
    suspend fun delete(element: T)
    suspend fun getAll(): Array<T>
    suspend fun getByIDs(taskIds: IntArray): Array<T>
    suspend fun getByQuery(query: SimpleSQLiteQuery): Array<T>

}