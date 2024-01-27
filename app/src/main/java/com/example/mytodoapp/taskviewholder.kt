package com.example.mytodoapp

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class taskviewholder (view: View) : RecyclerView.ViewHolder(view) {

    private val tvtask:TextView = view.findViewById(R.id.tvtask)
    private val cbtask:CheckBox = view.findViewById(R.id.cbtask)

    fun render (task: task){
        tvtask.text = task.name

    }
}