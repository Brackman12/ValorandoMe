package com.example.valorandome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Semana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semana);
    }

    public void SiguienteTres(View view){
        Intent intent = new Intent(this, Menu_Principal.class);
        startActivity(intent);
    }
    public void SiguienteCinco(View view){
        Intent intent = new Intent(this, Lecturas.class);
        startActivity(intent);
    }
    public void SiguienteOcho(View view){
        Intent intent = new Intent(this, examenes.class);
        startActivity(intent);
    }
    public void SiguienteNueve(View view){
        Intent intent = new Intent(this, Ejercicio_Practico.class);
        startActivity(intent);
    }
}