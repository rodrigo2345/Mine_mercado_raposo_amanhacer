package com.example.mine_mercado_raposo_amanhacer.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Cliente;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Contact;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Pedido;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;


public class ConfirmacaoPedidoActivity extends AppCompatActivity {

    private TextView totalTextView;
    private TextView detalhesTextView;
    private TextView nomeTextView;
    private TextView metodoPagamentoTextView;
    private TextView moradaTextView;
    private TextView telefoneTextView;
    private TextView quantidadeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao_pedido);

        totalTextView = findViewById(R.id.totalTextView);
        detalhesTextView = findViewById(R.id.detalhesTextView);
        nomeTextView = findViewById(R.id.nomeTextView);
        metodoPagamentoTextView = findViewById(R.id.metodoPagamentoTextView);
        moradaTextView = findViewById(R.id.moradaTextView);
        telefoneTextView = findViewById(R.id.telefoneTextView);
        quantidadeTextView = findViewById(R.id.quantidadeTextView);

        Intent intent = getIntent();
        if (intent != null) {
            double total = intent.getDoubleExtra("total", 0.0);
            List<Contact> carrinhoList = intent.getParcelableArrayListExtra("carrinhoList");
            String nome = intent.getStringExtra("nome");
            String metodoPagamento = intent.getStringExtra("metodo_pagamento");
            String morada = intent.getStringExtra("morada");
            String telefone = intent.getStringExtra("telefone");

            nomeTextView.setText("Cliente: " + nome);
            moradaTextView.setText("Morada: " + morada);
            telefoneTextView.setText("Telefone: " + telefone);
            metodoPagamentoTextView.setText("Método de pagamento: " + metodoPagamento);

            if (carrinhoList != null) {
                StringBuilder detalhes = new StringBuilder();
                StringBuilder quantidade = new StringBuilder();
                for (Contact contact : carrinhoList) {
                    detalhes.append(contact.getTitle()).append(" - ").append(contact.getLojaPrice()).append("\n");
                    quantidade.append("Quantidade: ").append(contact.getQuantity()).append("\n");
                }
                detalhesTextView.setText(detalhes.toString());
                quantidadeTextView.setText(quantidade.toString());
            }

            totalTextView.setText("Total: €" + String.format("%.2f", total));
        }
    }

    public void Search(View view) {
        Intent intent = new Intent(ConfirmacaoPedidoActivity.this, PesquisaActivity.class);
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = new Intent(ConfirmacaoPedidoActivity.this, MainActivity.class);
        startActivity(intent);
    }
}