package com.example.mytodoapp

//sealed class to take only these objects
sealed class taskcategory(var isSelected:Boolean = true) {
    object Personal: taskcategory()
    object Business: taskcategory()
    object Grocery: taskcategory()
    object Other: taskcategory()

}