package com.example.myplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddActivity : AppCompatActivity() {

    private lateinit var buttonAdicionar: Button
    private lateinit var edtTextCoisa: EditText
    private lateinit var coisaList: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        edtTextCoisa = findViewById(R.id.edtTextCoisa)
        buttonAdicionar = findViewById(R.id.buttonAdicionar)

        val i: Intent = intent
        coisaList = i.getStringArrayListExtra("coisaList")!!

        buttonAdicionar.setOnClickListener {
            var adicionar: String = buttonAdicionar.text.toString()
            coisaList.add(adicionar)
            finish()
        }
    }
}