package com.example.myfirstapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.myfirstapp.models.Task

@Dao
interface TaskDao : DBService<Task> {

   // because RawQuery can literally return any kinda table, we have to say which tables RawQuery should be expecting to return
   // also something something about Observables and them observing anything and everything
   @RawQuery(observedEntities = [Task::class])
   override fun getByQuery(query: SupportSQLiteQuery): LiveData<List<Task>>

   @Query("SELECT * FROM tasks")
   override fun getAll(): LiveData<List<Task>>

   @Query("SELECT * FROM tasks WHERE tid IN (:taskIds)")
   override fun getByIDs(taskIds: IntArray): LiveData<List<Task>>

   @Insert
   override fun insert(vararg elements: Task)

   @Delete
   override fun delete(element: Task)
}