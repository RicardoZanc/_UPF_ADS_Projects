package com.example.myplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var coisaList : ArrayList<String> = ArrayList()

    private lateinit var buttonAdd: FloatingActionButton
    private lateinit var listViewCoisas: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coisaList.addAll(listOf("coisa1", "cois2", "cois3"))

        listViewCoisas = findViewById(R.id.listViewCoisas)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonAdd.setOnClickListener { callAddActivity() }

        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, coisaList)
        listViewCoisas.adapter = adapter
    }

    private fun callAddActivity() {
        val i = Intent(this, AddActivity::class.java)
        i.putExtra("coisaList", coisaList)
        startActivity(i)
    }

    override fun onResume() {
        super.onResume()
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, coisaList)
        for()
        listViewCoisas.adapter = adapter
    }
}