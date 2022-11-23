package com.example.juegodel21;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity3 extends AppCompatActivity {

    private RequestQueue mQueue;
    TextView num;
    Button btnNumero,btnResultados,btnDarNumero;
    int numeroObtenido, mostrar;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mQueue = SingletonRequest.getInstance(MainActivity3.this).getRequestQueue();

        btnNumero = findViewById(R.id.pedirNumero);
        btnResultados = findViewById(R.id.resultados);
        btnDarNumero = findViewById(R.id.reset);

        btnDarNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num.setText("0");
                mostrar = 0;
                btnNumero.setEnabled(true);
            }
        });

        btnNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = findViewById(R.id.numero);
                String url = "https://ramiro.uttics.com/api/numero";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        numeros numero = gson.fromJson(response.toString(),numeros.class);
                        numeroObtenido = numero.getNumero();
                        mostrar = mostrar + numeroObtenido;
                        num.setText("" + mostrar);
                        if(mostrar == 21)
                        {
                            Toast.makeText(MainActivity3.this,"Ganaste",Toast.LENGTH_SHORT).show();
                            btnNumero.setEnabled(false);
                        }
                        else if (mostrar > 21)
                        {
                            Toast.makeText(MainActivity3.this,"Perdiste",Toast.LENGTH_SHORT).show();
                            btnNumero.setEnabled(false);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                mQueue.add(request);
            }
        });

        btnResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}