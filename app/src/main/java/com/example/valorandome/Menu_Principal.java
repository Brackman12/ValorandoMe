package com.example.valorandome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.valorandome.databinding.ActivityMainBinding;
import com.example.valorandome.databinding.ActivityMenuPrincipalBinding;
import com.example.valorandome.databinding.FragmentSettingsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;

public class Menu_Principal extends AppCompatActivity {

    ActivityMenuPrincipalBinding binding;

    EditText nombre, edad, direccion, dia;
    Button buscar, agregar, editar, eliminar;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu_principal);
        binding = ActivityMenuPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        /*nombre = (EditText) findViewById(R.id.nombres);
        edad = (EditText) findViewById(R.id.eda);
        direccion = (EditText) findViewById(R.id.direccio);
        dia = (EditText) findViewById(R.id.dia);
        agregar = (Button) findViewById(R.id.prueba);
        buscar = (Button) findViewById(R.id.prueba2);
        editar = (Button) findViewById(R.id.prueba4);
        eliminar = (Button) findViewById(R.id.prueba3);*/

        /*agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejecutarServicio("127.0.0.1:8080/codigophp/insertar.php");
            }
        });*/



        binding.bottomNavigationView.setOnItemSelectedListener( item -> {

            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new SettingsFragment());
                    break;
            }
            return true;
        });
    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();

    }

    public void SiguienteDos(View view){
        Intent intent = new Intent(this, Semana.class);
        startActivity(intent);
    }
    public void SiguienteOnce(View view){
        Intent intent = new Intent(this, Politicas_Privacidad.class);
        startActivity(intent);
    }
    public void SiguienteTrece(View view){
        Intent intent = new Intent(this, Ayuda.class);
        startActivity(intent);
    }
    public void SiguienteCatorce(View view){
        Intent intent = new Intent(this, HomeFragment.class);
        startActivity(intent);
    }


    private void ejecutarServicio(String URL){
        //Se utiliza el metodo POST ya que se utilizara POST, se le pasa como parametro la URL que se le envía anteriormente y el Response Listenes captura si la operacion es exitosa
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "OPERACION FALLIDA: "+ error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            protected Map<String,String>getParams() throws AuthFailureError{
                Map<String, String> parametros=new HashMap<String, String>();
                parametros.put("nombres", nombre.getText().toString());
                parametros.put("edad", edad.getText().toString());
                parametros.put("direccion", direccion.getText().toString());
                parametros.put("dias", dia.getText().toString());
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    /*private void buscarRegistro(String URL){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, onResponse(response)->{
            JSONObject jsonObject=null;
            for(int i=0; i<response.length(); i++){
                try{
                    jsonObject = response.getJSONObjet(i);

                }
            }
        };
    }
*/


}