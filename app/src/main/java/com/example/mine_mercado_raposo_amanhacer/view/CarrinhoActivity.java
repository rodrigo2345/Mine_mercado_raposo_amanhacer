package com.example.mine_mercado_raposo_amanhacer.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Contact;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Pedido;
import com.google.common.reflect.TypeToken;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

// CarrinhoActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CarrinhoAdapter adapter;
    private List<Contact> carrinhoList;
    private TextView totalTextView;
    private Button pagarButton;
    private RadioGroup paymentRadioGroup;
    private String clienteNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        clienteNome = getIntent().getStringExtra("nome");

        if (clienteNome == null || clienteNome.isEmpty()) {
            Toast.makeText(this, "Nome do cliente não encontrado.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        recyclerView = findViewById(R.id.recyclerViewCarrinho);
        totalTextView = findViewById(R.id.totalTextView);
        pagarButton = findViewById(R.id.pagarButton);
        paymentRadioGroup = findViewById(R.id.paymentRadioGroup);

        carrinhoList = retrieveCarrinhoList();
        updateTotal();

        adapter = new CarrinhoAdapter(this, carrinhoList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (carrinhoList != null && carrinhoList.isEmpty()) {
            pagarButton.setEnabled(false);
            Toast.makeText(this, "Adicione produtos ao carrinho para prosseguir com o pagamento.", Toast.LENGTH_SHORT).show();
        } else {
            pagarButton.setEnabled(true);
        }

        pagarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (carrinhoList.isEmpty()) {
                    Toast.makeText(CarrinhoActivity.this, "O carrinho está vazio.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int selectedId = paymentRadioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(CarrinhoActivity.this, "Selecione um método de pagamento.", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String metodoPagamento = selectedRadioButton.getText().toString();
                    enviarPedidoParaFirebase(carrinhoList, calcularTotal(carrinhoList), metodoPagamento);
                }
            }
        });

        TextView nomeTextView = findViewById(R.id.nomeTextView);
        nomeTextView.setText("Cliente: " + clienteNome);
    }

    private double calcularTotal(List<Contact> carrinhoList) {
        double total = 0.0;
        if (carrinhoList != null) {
            for (Contact contact : carrinhoList) {
                if (contact != null && contact.getLojaPrice() != null) {
                    total += Double.parseDouble(contact.getLojaPrice().replace("€", "").replace(",", ".")) * contact.getQuantity();
                }
            }
        }
        return total;
    }

    private void enviarPedidoParaFirebase(List<Contact> carrinhoList, double total, String metodoPagamento) {
        if (carrinhoList.isEmpty()) {
            Toast.makeText(CarrinhoActivity.this, "O carrinho está vazio.", Toast.LENGTH_SHORT).show();
            return;
        }

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference clienteRef = FirebaseDatabase.getInstance().getReference("clientes").child(userId);
        clienteRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String moradaCliente = dataSnapshot.child("morada").getValue(String.class);
                    String telefoneCliente = dataSnapshot.child("telefone").getValue(String.class);

                    Pedido pedido = new Pedido(userId, carrinhoList, total, clienteNome, metodoPagamento, moradaCliente, telefoneCliente);
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("pedidos");
                    databaseReference.push().setValue(pedido);

                    Intent intent = new Intent(CarrinhoActivity.this, ConfirmacaoPedidoActivity.class);
                    intent.putExtra("total", total);
                    intent.putParcelableArrayListExtra("carrinhoList", new ArrayList<>(carrinhoList));
                    intent.putExtra("nome", clienteNome);
                    intent.putExtra("metodo_pagamento", metodoPagamento);
                    intent.putExtra("morada", moradaCliente);
                    intent.putExtra("telefone", telefoneCliente);
                    startActivity(intent);

                    // Limpar o carrinho após o pagamento
                    saveCarrinhoList(new ArrayList<>());
                    carrinhoList.clear();
                    adapter.notifyDataSetChanged();
                    updateTotal();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("CarrinhoActivity", "Erro ao enviar pedido para o Firebase: " + databaseError.getMessage());
            }
        });
    }

    private List<Contact> retrieveCarrinhoList() {
        SharedPreferences preferences = getSharedPreferences("Carrinho", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("carrinhoList", null);
        Type type = new TypeToken<ArrayList<Contact>>() {}.getType();
        if (json != null) {
            return gson.fromJson(json, type);
        } else {
            return new ArrayList<>();
        }
    }

    public void updateTotal() {
        double total = calcularTotal(carrinhoList);
        totalTextView.setText("Total: €" + String.format("%.2f", total));
    }

    public void saveCarrinhoList(List<Contact> carrinhoList) {
        SharedPreferences preferences = getSharedPreferences("Carrinho", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(carrinhoList);
        editor.putString("carrinhoList", json);
        editor.apply();
    }
}