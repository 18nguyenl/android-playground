package com.example.myfirstapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val taskTable = "tasks"

@Entity(tableName = taskTable)
data class Task(
    @ColumnInfo(name = "sets") val sets: Int,
    @ColumnInfo(name = "reps") val reps: Int,
    @ColumnInfo(name = "tag") val tag: String,
    @ColumnInfo(name = "intensity") val intensity: Int,
    @ColumnInfo(name = "unit") val unit: String
) {
    // Use 0 as a default when creating the object or initializing the autogenerated key
    @PrimaryKey (autoGenerate = true) var id: Int = 0

    override fun toString(): String {
        return "Sets = $sets\nReps = $reps\nTag = $tag\nIntensity = $intensity\nUnit = $unit\n"
    }
}