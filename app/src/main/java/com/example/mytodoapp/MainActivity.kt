package com.example.mytodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodoapp.taskcategory.*

class MainActivity : AppCompatActivity() {

    private val categories = listOf(
        Other,
        Personal,
        Business,
        Grocery
    )

    private val task = mutableListOf(
        task("TestBussines", Business),
        task("TestPersonal", Other),
        task("TestOther", Personal),
        task("TestGrocery", Grocery)
        )

    private lateinit var rvcategories: RecyclerView
    private lateinit var categoriesadapter: categoriesadapter

    private lateinit var rvtasks:RecyclerView
    private lateinit var taskadapter: taskadapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent() //Generate component and initui functions
        initUI()
    }

    private fun initComponent() {
        rvcategories = findViewById(R.id.rvcategories)
        rvtasks = findViewById(R.id.rvtasks)
    }

    private fun initUI() {

        categoriesadapter = categoriesadapter(categories)
        rvcategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvcategories.adapter = categoriesadapter

        taskadapter = taskadapter(task)
        rvtasks.layoutManager = LinearLayoutManager(this)
        rvtasks.adapter = taskadapter
    }
}