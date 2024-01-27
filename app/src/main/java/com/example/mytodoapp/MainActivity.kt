package com.example.mytodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val categories = listOf(
        taskcategory.Other,
        taskcategory.Personal,
        taskcategory.Business,
        taskcategory.Grocery

    )

    private lateinit var rvcategories: RecyclerView
    private lateinit var categoriesadapter: categoriesadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent() //Generate component and initui functions
        initUI()
    }

    private fun initComponent() {
        rvcategories = findViewById(R.id.rvcategories)
    }

    private fun initUI() {

        categoriesadapter = categoriesadapter(categories)
        rvcategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvcategories.adapter = categoriesadapter

    }
}