package com.example.myfirstapp.data

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.myfirstapp.models.Hashtag
import com.example.myfirstapp.models.hashtagTable

@Dao
interface HashtagDao : DataAccessObject<Hashtag> {

    @RawQuery
    override suspend fun getByQuery(query: SimpleSQLiteQuery): List<Hashtag>

    @Query("SELECT * FROM $hashtagTable")
    override suspend fun getAll(): List<Hashtag>

    @Query("SELECT * FROM $hashtagTable WHERE id IN (:taskIds)")
    override suspend fun getByIDs(taskIds: IntArray): List<Hashtag>

    @Insert
    override suspend fun insert(vararg elements: Hashtag)

    @Delete
    override suspend fun delete(vararg element: Hashtag)

    @Update
    override suspend fun update(vararg element: Hashtag)

}