package com.example.myfirstapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
   @Query("SELECT * FROM tasks")
   fun getAll(): List<Task>

   @Query("SELECT * FROM tasks WHERE tid IN (:taskIds)")
   fun loadAllByIds(taskIds: IntArray): List<Task>

   @Insert
   fun insertAll(vararg tasks: Task)

   @Delete
   fun delete(task: Task)
}