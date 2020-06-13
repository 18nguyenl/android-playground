package com.example.myfirstapp.data

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery

interface DBService<T> {
    fun insert(vararg elements: @JvmSuppressWildcards T)
    fun delete(element: @JvmSuppressWildcards T)
    fun getAll(): LiveData<List<@JvmSuppressWildcards T>>
    fun getByIDs(taskIds: IntArray): LiveData<List<@JvmSuppressWildcards T>>
    fun getByQuery(query: SupportSQLiteQuery): LiveData<List<@JvmSuppressWildcards T>>
}