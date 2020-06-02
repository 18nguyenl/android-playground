package com.example.myfirstapp

import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private var task: Task? = null

    fun getTask(): Task? {
        return task
    }

    fun setTask(task: Task) {
        this.task = task
    }
}