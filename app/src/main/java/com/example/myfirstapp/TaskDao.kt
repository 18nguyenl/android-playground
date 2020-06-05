package com.example.myfirstapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
   @Query("SELECT * FROM tasks")
   suspend fun getAll(): Array<Task>

   @Query("SELECT * FROM tasks WHERE tid IN (:taskIds)")
   suspend fun loadAllByIds(taskIds: IntArray): Array<Task>

   @Insert
   suspend fun insertAll(vararg tasks: Task)

   @Delete
   suspend fun delete(task: Task)
}