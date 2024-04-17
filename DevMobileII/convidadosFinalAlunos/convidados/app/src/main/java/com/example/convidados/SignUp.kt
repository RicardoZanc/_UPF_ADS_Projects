package com.example.convidados

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class SignUp : AppCompatActivity() {

    private lateinit var databaseApp: SQLiteDatabase
    lateinit var edit_name : EditText
    lateinit var edit_email : EditText
    lateinit var edit_password : EditText
    lateinit var btnRegister: Button
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        toolbar = findViewById(R.id.my_toolbarSignUp)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        edit_name = findViewById(R.id.edit_name)
        edit_email = findViewById(R.id.edit_email)
        edit_password = findViewById(R.id.edit_password)
        btnRegister = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            save()
        }
    }

    private fun save() {
        try {
            databaseApp = openOrCreateDatabase("dbGuestApp", MODE_PRIVATE, null)
            var _email : String = edit_email.text.toString()
            val cursor: Cursor = databaseApp.rawQuery("SELECT email from userTable WHERE email = '$_email'", null)
            if (
                edit_name.text.toString().trim() == ""  || edit_email.text.toString().trim() == "" || edit_password.text.toString().trim() == ""
            ) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else if ( cursor.moveToFirst()) {
                Toast.makeText(this, "Já existe um usuário com este e-mail!", Toast.LENGTH_SHORT).show()
            } else {
                val sql = "INSERT INTO userTable (name, email, password) values (?,?,?)"
                val stmt = databaseApp.compileStatement(sql)
                stmt.bindString(1, edit_name.text.toString())
                stmt.bindString(2, edit_email.text.toString())
                stmt.bindString(3, edit_password.text.toString())
                stmt.executeInsert()
                databaseApp.close()
                edit_name.text.clear()
                edit_email.text.clear()
                edit_password.text.clear()
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            }
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }

}