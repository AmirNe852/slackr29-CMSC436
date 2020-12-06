package com.example.myapplication

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class ListClassActivity : AppCompatActivity(){
    internal lateinit var listViewClasses: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_classes)
        val myList = intent.getSerializableExtra("mylist") as ArrayList<Classes>
        val classListAdapter = ClassList(this@ListClassActivity, myList)
        listViewClasses.adapter = classListAdapter
    }
}