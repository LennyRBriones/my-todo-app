package com.example.mytodoapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class categoriesviewholder(view: View) : RecyclerView.ViewHolder(view){

    private val tvcategoryname:TextView = view.findViewById(R.id.tvcategoryname)

    private val divider:View = view.findViewById(R.id.divider)


    fun render(taskcategory: taskcategory){

        when(taskcategory){
            com.example.mytodoapp.taskcategory.Business -> {
                tvcategoryname.text = "Business"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context,R.color.business_category)
                )
            }
            com.example.mytodoapp.taskcategory.Personal -> {
                tvcategoryname.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context,R.color.personal_category)
                )

            }
            com.example.mytodoapp.taskcategory.Grocery -> {
                tvcategoryname.text = "Grocery"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context,R.color.groceries_category)
                )
            }
            com.example.mytodoapp.taskcategory.Other -> {
                tvcategoryname.text = "Other"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context,R.color.other_category)
                )

            }
        }

    }
}