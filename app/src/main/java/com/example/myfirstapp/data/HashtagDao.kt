package com.example.myfirstapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.myfirstapp.models.Hashtag
import com.example.myfirstapp.models.hashtagTable

@Dao
interface HashtagDao : DataAccessObject<Hashtag> {

    @RawQuery
    override fun getByQuery(query: SimpleSQLiteQuery): LiveData<List<Hashtag>>

    @Query("SELECT * FROM $hashtagTable")
    override fun getAll(): LiveData<List<Hashtag>>

    @Query("SELECT * FROM $hashtagTable WHERE id IN (:taskIds)")
    override fun getByIDs(taskIds: IntArray): LiveData<List<Hashtag>>

    @Insert
    override fun insert(vararg elements: Hashtag)

    @Delete
    override fun delete(vararg element: Hashtag)

    @Update
    override fun update(vararg element: Hashtag)

}