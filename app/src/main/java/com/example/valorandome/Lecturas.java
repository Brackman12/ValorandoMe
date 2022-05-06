package com.example.valorandome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lecturas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturas);
    }

    public void SiguienteCuatro(View view){
        Intent intent = new Intent(this, Semana.class);
        startActivity(intent);
    }
}