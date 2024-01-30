package com.example.mytodoapp

import android.view.View
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class categoriesviewholder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvcategoryname: TextView = view.findViewById(R.id.tvcategoryname)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewcontainer: CardView = view.findViewById(R.id.viewcontainer)


    fun render(taskcategory: taskcategory, onItemSelected: (Int) -> Unit) {

        var color = if (taskcategory.isSelected) {
            R.color.background_card
        } else {
            R.color.background_disable
        }

        viewcontainer.setCardBackgroundColor(ContextCompat.getColor(viewcontainer.context, color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when (taskcategory) {
            com.example.mytodoapp.taskcategory.Business -> {
                tvcategoryname.text = "Business"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.business_category)
                )
            }

            com.example.mytodoapp.taskcategory.Personal -> {
                tvcategoryname.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.personal_category)
                )

            }

            com.example.mytodoapp.taskcategory.Grocery -> {
                tvcategoryname.text = "Grocery"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.groceries_category)
                )
            }

            com.example.mytodoapp.taskcategory.Other -> {
                tvcategoryname.text = "Other"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.other_category)
                )

            }
        }

    }
}