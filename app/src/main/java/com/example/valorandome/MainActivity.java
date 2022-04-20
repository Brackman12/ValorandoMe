package com.example.valorandome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.view.*;
import android.util.Log;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //  ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.textView5);
    //myLayout.setOnTouchListener(new View.OnTouchListener(){
    //  @Override
    //    public boolean onTouch(View v, MotionEvent event){
    //  Log.i("TouchEvents","Touch is detected");

    //  return true;

    // }});


    //Metodo para cambiar de activity
    public void Siguiente(View view){
    Intent intent = new Intent(this, Menu_Principal.class);
    startActivity(intent);
    }
}