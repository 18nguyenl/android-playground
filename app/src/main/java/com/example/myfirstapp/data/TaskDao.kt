package com.example.myfirstapp.data

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.myfirstapp.models.Task

@Dao
interface TaskDao : DataAccessObject<Task> {

   @RawQuery
   override suspend fun getByQuery(query: SimpleSQLiteQuery): List<Task>

   @Query("SELECT * FROM tasks")
   override suspend fun getAll(): List<Task>

   @Query("SELECT * FROM tasks WHERE tid IN (:taskIds)")
   override suspend fun getByIDs(taskIds: IntArray): List<Task>

   @Insert
   override suspend fun insert(vararg elements: Task)

   @Delete
   override suspend fun delete(vararg element: Task)

   @Update
   override suspend fun update(vararg element: Task)
}