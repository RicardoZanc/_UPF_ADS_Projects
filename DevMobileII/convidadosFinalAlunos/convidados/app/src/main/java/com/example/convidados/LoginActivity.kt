package com.example.convidados

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var databaseApp: SQLiteDatabase
    lateinit var edtEmailLogin : EditText
    lateinit var edtPasswordLogin : EditText
    lateinit var btnLogin: Button
    lateinit var btnSignUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmailLogin = findViewById(R.id.edtEmailLogin)
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin)
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            login()
        }

        btnSignUp = findViewById(R.id.txtSignUp)
        btnSignUp.setOnClickListener {
            edtEmailLogin.text.clear()
            edtPasswordLogin.text.clear()
            var i = Intent(this, SignUp::class.java)
            startActivity(i)
        }
        createDatabase()
    }

    private fun createDatabase() {
        try {
            databaseApp = openOrCreateDatabase("dbGuestApp", MODE_PRIVATE, null)
            databaseApp.execSQL(
                "CREATE TABLE IF NOT EXISTS userTable" +
                        "(name VARCHAR, email VARCHAR PRIMARY KEY, password VARCHAR)"
            )
            databaseApp.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun login() {
        var _email : String = edtEmailLogin.text.toString()
        var _password : String = edtPasswordLogin.text.toString()
        databaseApp = openOrCreateDatabase("dbGuestApp", MODE_PRIVATE, null)

        val cursor : Cursor = databaseApp.rawQuery("SELECT email, password FROM userTable " +
                "WHERE email = '$_email' AND password = '$_password'", null)

        if (
            edtEmailLogin.text.toString().trim() == "" || edtPasswordLogin.text.toString().trim() == ""
        ) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
        } else if( cursor.moveToFirst() ) {
            var i = Intent(this, MainActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)
        } else {
                Toast.makeText(this, "Login inválido!", Toast.LENGTH_SHORT).show()
            }
            databaseApp.close()
        }
}