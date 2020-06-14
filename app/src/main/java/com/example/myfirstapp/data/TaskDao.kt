package com.example.myfirstapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.myfirstapp.models.Task

@Dao
interface TaskDao : DataAccessObject<Task> {

   // because RawQuery can literally return any kinda table, we have to say which tables RawQuery should be expecting to return
   // also something something about Observables and them observing anything and everything
   @RawQuery(observedEntities = [Task::class])
   override fun getByQuery(query: SimpleSQLiteQuery): LiveData<List<@JvmSuppressWildcards Task>>

   @Query("SELECT * FROM tasks")
   override fun getAll(): LiveData<List<@JvmSuppressWildcards Task>>

   @Query("SELECT * FROM tasks WHERE id IN (:taskIds)")
   override fun getByIDs(taskIds: IntArray): LiveData<List<@JvmSuppressWildcards Task>>

   @Insert
   override fun insert(vararg elements: @JvmSuppressWildcards Task)

   @Delete
   override fun delete(vararg element: @JvmSuppressWildcards Task)

   @Update
   override fun update(vararg element: @JvmSuppressWildcards Task)


}