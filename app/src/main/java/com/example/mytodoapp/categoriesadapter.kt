package com.example.mytodoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class categoriesadapter (private val categories:List<taskcategory>, private val onItemSelected:(Int) -> Unit):
    RecyclerView.Adapter<categoriesviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoriesviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return categoriesviewholder(view)
    }

    //shows the total of items that you define
    override fun getItemCount() = categories.size //setting the size of the value

    override fun onBindViewHolder(holder: categoriesviewholder, position: Int) {
        holder.render(categories[position], onItemSelected)
    }

}