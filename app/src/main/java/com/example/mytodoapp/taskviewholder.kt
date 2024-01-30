package com.example.mytodoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class taskviewholder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvtask: TextView = view.findViewById(R.id.tvtask)
    private val cbtask: CheckBox = view.findViewById(R.id.cbtask)

    fun render(task: task) {

        if (task.isSelected) {
            tvtask.paintFlags = tvtask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvtask.paintFlags = tvtask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        tvtask.text = task.name
        cbtask.isChecked = task.isSelected

        val color = when (task.category) {
            taskcategory.Business -> R.color.business_category
            taskcategory.Other -> R.color.other_category
            taskcategory.Personal -> R.color.personal_category
            taskcategory.Grocery -> R.color.groceries_category


        }

        cbtask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbtask.context, color)
        )


    }
}