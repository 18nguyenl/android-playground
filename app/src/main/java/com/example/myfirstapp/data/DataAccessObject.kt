package com.example.myfirstapp.data

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SimpleSQLiteQuery

interface DataAccessObject<T> {

    fun insert(vararg elements: @JvmSuppressWildcards T)
    fun delete(vararg element: @JvmSuppressWildcards T)
    fun update(vararg element: @JvmSuppressWildcards T)

    fun getAll(): LiveData<List<@JvmSuppressWildcards T>>
    fun getByIDs(ids: IntArray): LiveData<List<@JvmSuppressWildcards T>>
    fun getByID(id: Int): LiveData<@JvmSuppressWildcards T>
    fun getByQuery(query: SimpleSQLiteQuery): LiveData<List<@JvmSuppressWildcards T>>

}