package com.example.mine_mercado_raposo_amanhacer.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Contact;
import com.google.common.reflect.TypeToken;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class activity_Poupa_Tomate_amanhecer extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactAdapter adapter;
    private List<Contact> carrinhoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poupa_tomate_amanhecer);

        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Polpa Tomate  AMANCHECER", "0,35€", R.drawable.tomate_poupa));

        recyclerView = findViewById(R.id.recyclerView_product2);
        carrinhoList = retrieveCarrinhoList();

        adapter = new ContactAdapter(this, contactList, carrinhoList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private List<Contact> retrieveCarrinhoList() {
        SharedPreferences preferences = getSharedPreferences("Carrinho", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("carrinhoList", null);
        Type type = new TypeToken<ArrayList<Contact>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public void Search(View view) {
        Intent intent = new Intent(activity_Poupa_Tomate_amanhecer.this, PesquisaActivity.class);
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = new Intent(activity_Poupa_Tomate_amanhecer.this, MainActivity.class);
        startActivity(intent);
    }
    public void openCarrinhoActivity(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("clientes").child(user.getUid());
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String nomeUsuario = snapshot.child("nome").getValue(String.class);
                        if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
                            Intent intent = new Intent(activity_Poupa_Tomate_amanhecer.this, CarrinhoActivity.class);
                            intent.putExtra("nome", nomeUsuario);
                            startActivity(intent);
                        } else {
                            Toast.makeText(activity_Poupa_Tomate_amanhecer.this, "Nome do cliente não encontrado.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(activity_Poupa_Tomate_amanhecer.this, "Cliente não encontrado.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(activity_Poupa_Tomate_amanhecer.this, "Erro ao recuperar dados do cliente.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity_Poupa_Tomate_amanhecer.this, "Usuário não autenticado.", Toast.LENGTH_SHORT).show();
        }
    }
}
