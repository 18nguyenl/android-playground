package com.example.myfirstapp.data

import androidx.sqlite.db.SimpleSQLiteQuery

interface DataAccessObject<T> {

    suspend fun insert(vararg elements: @JvmSuppressWildcards T)
    suspend fun delete(vararg element: @JvmSuppressWildcards T)
    suspend fun update(vararg element: @JvmSuppressWildcards T)
    suspend fun getAll(): List<@JvmSuppressWildcards T>
    suspend fun getByIDs(taskIds: IntArray): List<@JvmSuppressWildcards T>
    suspend fun getByQuery(query: SimpleSQLiteQuery): List<@JvmSuppressWildcards T>

}