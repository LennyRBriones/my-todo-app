package com.example.mytodoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class taskadapter (private val task:List<task>): RecyclerView.Adapter<taskviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): taskviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return taskviewholder(view)
    }

    override fun getItemCount() = task.size

    override fun onBindViewHolder(holder: taskviewholder, position: Int) {
        holder.render(task[position])
    }
}