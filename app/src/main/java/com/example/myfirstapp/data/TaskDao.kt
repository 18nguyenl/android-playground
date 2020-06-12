package com.example.myfirstapp.data

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.myfirstapp.models.Task

@Dao
interface TaskDao : DBService<Task> {

   @RawQuery
   override suspend fun getByQuery(query: SimpleSQLiteQuery): Array<Task>

   @Query("SELECT * FROM tasks")
   override suspend fun getAll(): Array<Task>

   @Query("SELECT * FROM tasks WHERE tid IN (:taskIds)")
   override suspend fun getByIDs(taskIds: IntArray): Array<Task>

   @Insert
   override suspend fun insert(vararg tasks: Task)

   @Delete
   override suspend fun delete(task: Task)
}