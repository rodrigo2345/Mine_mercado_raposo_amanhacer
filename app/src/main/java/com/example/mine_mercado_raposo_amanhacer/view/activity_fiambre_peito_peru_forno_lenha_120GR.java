package com.example.mine_mercado_raposo_amanhacer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Contact;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class activity_fiambre_peito_peru_forno_lenha_120GR extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactAdapter adapter;
    private List<Contact> carrinhoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiambre_peito_peru_forno_lenha120_gr);
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Campofrio Fiambre Peito Peru Forno de Lenha Finas Fatiado 120GR", "2,99€", R.drawable.fiambre_peito_peru_forno_lenha_120gr, 1));
        recyclerView = findViewById(R.id.recyclerView_product27);
        carrinhoList = getCarrinhoListFromSharedPreferences();

        adapter = new ContactAdapter(this, contactList, carrinhoList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private List<Contact> getCarrinhoListFromSharedPreferences() {
        SharedPreferences preferences = getSharedPreferences("Carrinho", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("carrinhoList", null);
        if (json != null) {
            Type type = new TypeToken<ArrayList<Contact>>() {
            }.getType();
            return gson.fromJson(json, type);
        } else {
            return new ArrayList<>();
        }
    }

    public void Search(View view) {
        Intent intent = new Intent(activity_fiambre_peito_peru_forno_lenha_120GR.this, PesquisaActivity.class);
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = new Intent(activity_fiambre_peito_peru_forno_lenha_120GR.this, MainActivity.class);
        startActivity(intent);
    }
}