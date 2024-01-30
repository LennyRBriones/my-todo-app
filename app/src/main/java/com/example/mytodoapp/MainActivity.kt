package com.example.mytodoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodoapp.taskcategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

    private lateinit var fabaddtask:FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent() //Generate component and initui functions
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabaddtask.setOnClickListener{showdialog()}
    }

    private fun showdialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        val btnaddtask:Button = dialog.findViewById(R.id.btnaddtask)
        val ettask: EditText = dialog.findViewById(R.id.ettask)
        val rgcategories: RadioGroup = dialog.findViewById(R.id.rgcategories)

        btnaddtask.setOnClickListener {
            val currenttask = ettask.text.toString()
            if(currenttask.isNotEmpty()){
            val selectedid = rgcategories.checkedRadioButtonId // return the id of the button
            val selectedradiobutton:RadioButton = rgcategories.findViewById(selectedid)
            val currentcategory:taskcategory = when(selectedradiobutton.text){
                getString(R.string.rdbussines) -> Business
                getString(R.string.rdpersonal) -> Personal
                getString(R.string.rdgroceries) -> Grocery

                else -> Other

            }
            task.add(task(currenttask, currentcategory)) //add the task added
            updatetask()
            dialog.hide()
          }
        }
        dialog.show()

    }
    private fun initComponent() {
        rvcategories = findViewById(R.id.rvcategories)
        rvtasks = findViewById(R.id.rvtasks)
        fabaddtask = findViewById(R.id.fabaddtask)
    }

    private fun initUI() {

        categoriesadapter = categoriesadapter(categories) { position -> updatecategories(position) }
        rvcategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvcategories.adapter = categoriesadapter

        taskadapter = taskadapter(task) { position -> onitemselected(position)} //lambda function
        rvtasks.layoutManager = LinearLayoutManager(this)
        rvtasks.adapter = taskadapter
    }

    private fun onitemselected(position:Int){
        task[position].isSelected = !task[position].isSelected
        updatetask()
    }

    private fun updatecategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesadapter.notifyItemChanged(position)
        updatetask()
    }

    private fun updatetask(){
        val selectedcategories: List<taskcategory> = categories.filter { it.isSelected}
        val newtask = task.filter {selectedcategories.contains(it.category) }
        taskadapter.task = newtask
        taskadapter.notifyDataSetChanged()
    }
}