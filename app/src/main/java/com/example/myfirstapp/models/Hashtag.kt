package com.example.myfirstapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val hashtagTable = "hashtags"

@Entity(tableName = hashtagTable)
data class Hashtag(
    @ColumnInfo(name = "name") val name: String
) {

    @PrimaryKey(autoGenerate = true) var id: Int = 0

    override fun toString(): String {
        return "#$name"
    }

}