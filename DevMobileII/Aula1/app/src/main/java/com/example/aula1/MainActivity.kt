package com.example.aula1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener{
            calculaGasto()
        }
    }

    fun calculaGasto() {
        var distancia:Float = findViewById<EditText>(R.id.edtDistancia).text.toString().toFloat()
        var preco:Float = findViewById<EditText>(R.id.edtPreco).text.toString().toFloat()
        var autonomia:Float = findViewById<EditText>(R.id.edtAutonomia).text.toString().toFloat()

        var valorFinal: Float = (distancia * preco) / autonomia

        findViewById<TextView>(R.id.txtResultado).text = "R$ ${"%,2f".format(valorFinal)}"

        Toast.makeText(this,"Calculado!", Toast.LENGTH_SHORT).show()
    }
}