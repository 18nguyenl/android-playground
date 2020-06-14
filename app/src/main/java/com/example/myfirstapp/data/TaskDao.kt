package com.example.myfirstapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.models.taskTable

@Dao
interface TaskDao : DataAccessObject<Task> {

   // because RawQuery can literally return any kinda table, we have to say which tables RawQuery should be expecting to return
   // also something something about Observables and them observing anything and everything
   @RawQuery(observedEntities = [Task::class])
   override fun getByQuery(query: SimpleSQLiteQuery): LiveData<List<@JvmSuppressWildcards Task>>

   @Query("SELECT * FROM $taskTable")
   override fun getAll(): LiveData<List<@JvmSuppressWildcards Task>>

   @Query("SELECT * FROM $taskTable WHERE id IN (:ids)")
   override fun getByIDs(ids: IntArray): LiveData<List<@JvmSuppressWildcards Task>>

   @Query("SELECT * FROM $taskTable WHERE id = :id")
   override fun getByID(id: Int): LiveData<@JvmSuppressWildcards Task>

   @Insert
   override fun insert(vararg elements: @JvmSuppressWildcards Task)

   @Delete
   override fun delete(vararg element: @JvmSuppressWildcards Task)

   @Update
   override fun update(vararg element: @JvmSuppressWildcards Task)


}