package com.example.myappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add("Sair");
        menu.add("Voltar");
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}