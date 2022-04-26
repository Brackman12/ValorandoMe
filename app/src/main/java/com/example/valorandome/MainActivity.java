package com.example.valorandome;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.view.*;
import android.util.Log;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText) findViewById(R.id.et_user);
        pass=(EditText) findViewById(R.id.et_pass);
        bt_login=(Button) findViewById(R.id.bt1);

        bt_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ejecutarServicio("http://127.0.0.1:8080/codigophp/insertar.php");
            }
        });

    }

    //Metodo que envía peticiones al servidor
    private void ejecutarServicio(String URL){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operacion hecha con exito", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(), "Operacion Fallida", Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros=new HashMap<String, String>();
                parametros.put("nombres", user.getText().toString());
                parametros.put("edad", pass.getText().toString());
                parametros.put("direccion", user.getText().toString());
                parametros.put("dias", pass.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    //Metodo para cambiar de activity
    public void Siguiente(View view){
    Intent intent = new Intent(this, Menu_Principal.class);
    startActivity(intent);
    }



}