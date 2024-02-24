package com.example.myappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaPessoasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pessoas);
        ListView listview = (ListView) findViewById(R.id.listPessoa);
        String[] dados = new String[] {"Pedro", "Paulo","Alice","Joana","Maria"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
        listview.setAdapter(adapter);
    }
}