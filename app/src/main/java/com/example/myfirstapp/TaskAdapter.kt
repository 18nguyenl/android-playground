package com.example.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.models.Task

class TaskAdapter() : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private var tasks = emptyList<Task>()

    class TaskViewHolder (listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        // itemView is listItemView
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
        holder.itemView.setOnClickListener { view -> view.findNavController().navigate(R.id.action_home_to_counter)}
        holder.taskIntensityText.text = "${tasks[position]?.intensity} ${tasks[position]?.unit}"
        holder.taskFrequencyText.text = "${tasks[position]?.sets} × ${tasks[position]?.reps}"
        holder.taskTagText.text = "${tasks[position]?.tag}"
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    // Internal is an access modifier. It lets any object of the same module/package see this member
    internal fun setTasks(tasks: List<Task>) {
       this.tasks = tasks
        notifyDataSetChanged() // Something in the RecyclerView had changed and it should update itself to reflect the new data
    }
}