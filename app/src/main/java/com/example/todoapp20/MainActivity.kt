package com.example.todoapp20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()

{
    private lateinit var taskAdapter : Adapter
    override fun onCreate(savedInstanceState: Bundle?)

    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.recycle_view)
        taskAdapter = Adapter(mutableListOf())

        rv.adapter = taskAdapter
        rv.layoutManager = LinearLayoutManager(this)

        var editT = findViewById<EditText>(R.id.editT)
        var btn1 = findViewById<Button>(R.id.add)

        btn1.setOnClickListener{
            val tasks = editT.text.toString()
            if(tasks=="")
            {
                Toast.makeText(this, "Write your Data", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val task1 = datas(tasks)
                taskAdapter.addTask(task1)
                editT.text.clear()
            }
        }
    }
}