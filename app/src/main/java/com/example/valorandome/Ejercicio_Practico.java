package com.example.valorandome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ejercicio_Practico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_practico);
    }

    public void SiguienteSeis(View view){
        Intent intent = new Intent(this, Semana.class);
        startActivity(intent);
    }
}