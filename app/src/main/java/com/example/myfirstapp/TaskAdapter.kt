package com.example.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val task: Task) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    class TaskViewHolder (val listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val taskIntensityText: TextView = itemView.findViewById<TextView>(R.id.taskIntensityText)
        val taskFrequencyText: TextView = itemView.findViewById<TextView>(R.id.taskFrequencyText)
        val taskTagText: TextView = itemView.findViewById<TextView>(R.id.taskTagText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val row = LayoutInflater.from (parent.context)
            .inflate(R.layout.task_text_view, parent, false)

        return TaskViewHolder(row)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.taskIntensityText.text = "${task.intensity} ${task.unit}"
        holder.taskFrequencyText.text = "${task.sets} × ${task.reps}"
        holder.taskTagText.text = "${task.tag}"
    }

    override fun getItemCount(): Int {
        return 1
    }
}