package com.example.myfirstapp.services

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myfirstapp.models.Task

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