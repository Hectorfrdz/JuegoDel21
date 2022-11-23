package com.example.juegodel21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ganadoresAdapter adapter;
    List<ganadores> a;
    List<data> nombre;

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mQueue = SingletonRequest.getInstance(MainActivity.this).getRequestQueue();
        a = new ArrayList<>();
        nombre= new ArrayList<>();

        getPokemon();

    }

    public  void getPokemon(){
        String urlApi ="https://ramiro.uttics.com/api/ganadores";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlApi, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                RecyclerView recyclerView = findViewById(R.id.ganadores);

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Gson gson = new Gson();
                ganadores pk = gson.fromJson(response.toString(), ganadores.class);
                adapter = new ganadoresAdapter(pk.getData());

                recyclerView.setAdapter(adapter);
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}