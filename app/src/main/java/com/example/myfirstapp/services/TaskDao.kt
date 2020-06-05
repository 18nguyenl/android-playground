package com.example.myfirstapp.services

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.myfirstapp.models.Task

@Dao
interface TaskDao {

   @RawQuery
   suspend fun getByQuery(query: SimpleSQLiteQuery): Array<Task>

   @Query("SELECT * FROM tasks")
   suspend fun getAll(): Array<Task>

   @Query("SELECT * FROM tasks WHERE tid IN (:taskIds)")
   suspend fun getByIDs(taskIds: IntArray): Array<Task>

   @Insert
   suspend fun insertAll(vararg tasks: Task)

   @Delete
   suspend fun delete(task: Task)
}