package com.example.convidados

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var databaseApp:SQLiteDatabase
    private var guestList: ArrayList<GuestModel> = ArrayList()
    private lateinit var listViewGuests: ListView
    private lateinit var btnAdd:FloatingActionButton
    private var ID_SELECIONADO: Int? = null

    override fun onResume() {
        super.onResume()
        getGuestList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val intent = Intent(this, GuestForm::class.java)
            startActivity(intent)
        }
        listViewGuests = findViewById(R.id.listViewGuests)
        listViewGuests.setOnItemClickListener { _, _, idx, _ ->
            println("o indice da lista clicado é o $idx")
            println("o id do cara clicado é o ${guestList[idx].id}")
            ID_SELECIONADO = guestList[idx].id
            val intent = Intent(this, GuestForm::class.java)
            intent.putExtra("ID_SELECIONADO", ID_SELECIONADO)
            startActivity(intent)
        }
        createDatabase()
        getGuestList()
    }

    private fun getGuestList() {
        try {
            guestList = ArrayList()
            databaseApp = openOrCreateDatabase("dbGuestApp", MODE_PRIVATE, null)
            //retorna o resultado da consulta
            val cursor: Cursor = databaseApp.rawQuery("SELECT id, name from guestTable", null)

            //alimentando o array list de convidados
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                println(GuestModel(cursor.getInt(0), cursor.getString(1)))
                guestList.add(GuestModel(cursor.getInt(0), cursor.getString(1)))
                cursor.moveToNext()
            }
            cursor.close()
            println(guestList)
            //adaptando o conteudo ao list view
            val adatpterGuest: ArrayAdapter<GuestModel> = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                guestList
            )
            listViewGuests.adapter = adatpterGuest
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun createDatabase() {
        try {
            databaseApp = openOrCreateDatabase("dbGuestApp", MODE_PRIVATE, null)
            databaseApp.execSQL("CREATE TABLE IF NOT EXISTS guestTable" +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)")
            databaseApp.close()
        } catch(e: Exception) {
           e.printStackTrace()
        }
    }
}