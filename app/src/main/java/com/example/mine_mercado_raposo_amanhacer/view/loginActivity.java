package com.example.mine_mercado_raposo_amanhacer.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.Util.ConfiguraBd;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Cliente;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;

    private FirebaseAuth auth;
    private Button loginButton;
    private Button forgotPasswordButton;

    private int failedLoginAttempts = 0;
    private static final int MAX_FAILED_LOGIN_ATTEMPTS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = ConfiguraBd.Firebaseautenticacao();
        inicializarComponentes();

        // Limpar o carrinho ao abrir a tela de login
        limparCarrinho();
    }

    private void limparCarrinho() {
        SharedPreferences preferences = getSharedPreferences("Carrinho", Context.MODE_PRIVATE);
        preferences.edit().clear().apply();
    }

    public void validarAutentificacao(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {
            Cliente cliente = new Cliente();
            cliente.setEmail(email);
            cliente.setPassword(password);
            logar(cliente);
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void logar(Cliente cliente) {
        ProgressBar progressBar = findViewById(R.id.loginProgressBar);
        progressBar.setVisibility(View.VISIBLE);

        auth.signInWithEmailAndPassword(
                cliente.getEmail(), cliente.getPassword()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful()) {
                    failedLoginAttempts = 0;
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("clientes").child(user.getUid());
                        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()) {
                                    String nomeUsuario = snapshot.child("nome").getValue(String.class);
                                    if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
                                        Toast.makeText(loginActivity.this, "Bem-vindo, " + nomeUsuario + " 😊", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(loginActivity.this, "Bem-vindo! 😊", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(loginActivity.this, "Bem-vindo! 😊", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(loginActivity.this, "Erro ao recuperar dados do usuário.", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            abrirHome();
                        }
                    }, 1000);

                } else {
                    failedLoginAttempts++;
                    if (failedLoginAttempts >= MAX_FAILED_LOGIN_ATTEMPTS) {
                        bloquearContaTemporariamente();
                    }
                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Cliente não está registrado";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Email ou senha incorretos";
                    } catch (Exception e) {
                        excecao = "Erro ao iniciar sessão";
                        e.printStackTrace();
                    }
                    Toast.makeText(loginActivity.this, excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void abrirHome() {
        Intent i = new Intent(loginActivity.this, MainActivity.class);
        startActivity(i);
    }

    private void inicializarComponentes() {
        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.bt_mestra);
        forgotPasswordButton = findViewById(R.id.bt_forgot_password);
    }

    public void RegisterHere(View view) {
        Intent intent = new Intent(loginActivity.this, registerActivity.class);
        startActivity(intent);
    }

    private void recuperarSenha(String email) {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(loginActivity.this, "E-mail de recuperação de senha enviado. Verifique sua caixa de entrada.", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = auth.getCurrentUser();
                            if (user != null) {
                                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("clientes");
                                databaseReference.child(user.getUid()).child("email").setValue(email);
                            }
                        } else {
                            Toast.makeText(loginActivity.this, "Falha ao enviar e-mail de recuperação de senha. Verifique o endereço de e-mail fornecido.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void onForgotPasswordClicked(View view) {
        String email = emailEditText.getText().toString();
        if (!email.isEmpty()) {
            recuperarSenha(email);
        } else {
            Toast.makeText(this, "Por favor, insira seu e-mail para recuperar a senha.", Toast.LENGTH_SHORT).show();
        }
    }

    private void bloquearContaTemporariamente() {
        loginButton.setEnabled(false);
        Toast.makeText(this, "Conta temporariamente bloqueada devido a múltiplas tentativas de login malsucedidas.", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginButton.setEnabled(true);
                Toast.makeText(loginActivity.this, "Conta desbloqueada. Tente fazer login novamente.", Toast.LENGTH_SHORT).show();
                failedLoginAttempts = 0;
            }
        }, 30000);
    }

    public void openFacebookPage(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/minimercadoraposo"));
        startActivity(intent);
    }

    public void openInstagramPage(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/minimercadoraposociborro/"));
        startActivity(intent);
    }
}
