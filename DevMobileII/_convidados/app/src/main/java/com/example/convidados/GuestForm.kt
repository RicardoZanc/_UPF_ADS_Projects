package com.example.convidados

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText

class GuestForm : AppCompatActivity() {
    private lateinit var databaseApp: SQLiteDatabase
    private lateinit var edtGuestName: EditText
    private lateinit var btnSave: Button
    private var idReceivedParam: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        val intent: Intent = intent
        idReceivedParam = intent.getIntExtra("ID_SELECIONADO", 0)
        edtGuestName = findViewById(R.id.edtGuestName)
        load()


        btnSave = findViewById(R.id.btnSave)
        btnSave.setOnClickListener {
            save()
        }
    }

    private fun load() {
        try {
            databaseApp = openOrCreateDatabase("dbGuestApp", MODE_PRIVATE, null)
            val cursor: Cursor = databaseApp.rawQuery("SELECT id, name from guestTable WHERE id= "+idReceivedParam, null)
            cursor.moveToFirst()
            edtGuestName.setText(cursor.getString(1))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun save() {
        try {
            databaseApp = openOrCreateDatabase("dbGuestApp", MODE_PRIVATE, null)
            val sql = "INSERT INTO guestTable (name) values (?)"
            val stmt =  databaseApp.compileStatement(sql)
            stmt.bindString(1, edtGuestName.text.toString())
            stmt.executeInsert()
            databaseApp.close()
        } catch (e:Exception) {
            e.printStackTrace()
        }
        finish()
    }
}