package com.example.myfirstapp

class Task(sets: Int, reps: Int, tag: String, intensity: Int, unit: String) {
    var tag: String = ""
    var sets: Int = 0
    var reps: Int = 0
    var intensity: Int = 0
    var unit: String = ""

    init {
        this.sets = sets
        this.reps = reps
        this.tag = tag
        this.intensity = intensity
        this.unit = unit
    }

    override fun toString(): String {
       return "Sets = $sets\nReps = $reps\nTag = $tag\nIntensity = $intensity\nUnit = $unit\n"
    }
}