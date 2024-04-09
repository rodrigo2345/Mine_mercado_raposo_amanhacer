package com.example.mine_mercado_raposo_amanhacer.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
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

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        auth = FirebaseAuth.getInstance();
        WebView webView = findViewById(R.id.webView);

        String video = "<html><body style=\"margin:0;padding:0;\"><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/c3Z3ySU0H-A?si=tyDvj0V-gm7ZPdFi\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        webView.loadData(video, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
    }
    public void deslogar(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tem certeza que deseja sair?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    // Limpar o carrinho ao fazer logout
                    SharedPreferences preferences = getSharedPreferences("Carrinho", Context.MODE_PRIVATE);
                    preferences.edit().clear().apply();

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String nomeUsuario = "";
                    if (user != null) {
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("clientes").child(user.getUid());
                        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()) {
                                    String nomeUsuario = snapshot.child("nome").getValue(String.class);
                                    if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
                                        exibirMensagemDespedida(nomeUsuario);
                                    } else {
                                        exibirMensagemDespedida("");
                                    }
                                } else {
                                    exibirMensagemDespedida("");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                exibirMensagemDespedida("");
                            }
                        });
                    }
                    FirebaseAuth.getInstance().signOut();

                    Intent intent = new Intent(MainActivity.this, loginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void exibirMensagemDespedida(String nomeUsuario) {
        String emoji = " 😢";
        String mensagem = "Volte em Breve";
        if (!nomeUsuario.isEmpty()) {
            mensagem = "Volte em Breve, " + nomeUsuario + emoji;
        }
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
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
                            Intent intent = new Intent(MainActivity.this, CarrinhoActivity.class);
                            intent.putExtra("nome", nomeUsuario);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Nome do cliente não encontrado.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Cliente não encontrado.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(MainActivity.this, "Erro ao recuperar dados do cliente.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(MainActivity.this, "Usuário não autenticado.", Toast.LENGTH_SHORT).show();
        }
    }


    public void Search(View view) {
        Intent intent = new Intent(MainActivity.this, PesquisaActivity.class);
        startActivity(intent);
    }
    public void Share(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityShare.class);
        startActivity(intent);
    }

    public void Sobre(View view) {
        Intent intent = new Intent(MainActivity.this, SobreActivity.class);
        startActivity(intent);
    }
}