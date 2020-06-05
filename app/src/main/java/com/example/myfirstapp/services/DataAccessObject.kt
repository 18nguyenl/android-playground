package com.example.myfirstapp.services

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataAccessObject<T> {

    //val tableName: String

    //@Query(":queryField")
    //suspend fun query(queryField: String): Array<T>

    @Query("SELECT * FROM tasks")
    suspend fun getAll(): Array<T>

    @Query("SELECT * FROM tasks WHERE tid IN (:taskIds)")
    suspend fun loadAllByIds(taskIds: IntArray): Array<T>

    @Insert
    suspend fun insertAll(vararg tasks: T)

    @Delete
    suspend fun delete(task: T)

}