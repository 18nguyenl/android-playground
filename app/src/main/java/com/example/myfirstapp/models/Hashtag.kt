package com.example.myfirstapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hashtags")
class Hashtag(@ColumnInfo(name = "name") val name: String) {

    @PrimaryKey(autoGenerate = true) var tid: Int = 0

    override fun toString(): String {
        return "#$name"
    }

}