package com.example.mine_mercado_raposo_amanhacer.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.Util.ClienteAutenticado;
import com.example.mine_mercado_raposo_amanhacer.Util.ConfiguraBd;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Cliente;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class registerActivity extends AppCompatActivity {

    EditText edtNome, edtEmail, edtDistrito, edtMorada, edttelefone, edtPassword;
    FirebaseAuth autenticacao;
    Button registerButton;
    DatabaseReference databaseReference;
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inicializar();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCampos();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("clientes");
    }

    // Método para inicializar componentes de UI
    private void inicializar() {
        edtNome = findViewById(R.id.et_nome);
        edtEmail = findViewById(R.id.et_email);
        edtDistrito = findViewById(R.id.et_distrito);
        edtMorada = findViewById(R.id.et_morada);
        edttelefone = findViewById(R.id.et_telefone);
        edtPassword = findViewById(R.id.et_password);
        registerButton = findViewById(R.id.btn_registrar);

        edtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    edtEmail.setTextColor(Color.BLACK);
            }
        });

        edttelefone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    edttelefone.setTextColor(Color.BLACK);
            }
        });
    }

    private void validarCampos() {
        String nome = edtNome.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String distrito = edtDistrito.getText().toString().trim();
        String morada = edtMorada.getText().toString().trim();
        String telefone = edttelefone.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (!nome.isEmpty() && !email.isEmpty() && !distrito.isEmpty() && !morada.isEmpty() && !telefone.isEmpty() && !password.isEmpty()) {
            if (telefone.length() == 9) {
                cliente = new Cliente();
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setDistrito(distrito);
                cliente.setMorada(morada);
                cliente.setTelefone(telefone);
                cliente.setPassword(password);

                verificarEmailEUsernameExistente();
            } else {
                if (telefone.length() < 9) {
                    Toast.makeText(this, "Número de telefone inválido. Deve ter 9 dígitos.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Número de telefone inválido. Deve ter exatamente 9 dígitos.", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void verificarEmailEUsernameExistente() {
        String email = edtEmail.getText().toString().trim();

        databaseReference.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    edtEmail.setTextColor(Color.RED);
                    Toast.makeText(registerActivity.this, "Email já existe", Toast.LENGTH_LONG).show();
                } else {
                    edtEmail.setTextColor(Color.BLACK);
                    verificarTelefoneExistente();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(registerActivity.this, "Erro ao verificar o email", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void verificarTelefoneExistente() {
        String telefone = edttelefone.getText().toString().trim();

        databaseReference.orderByChild("telefone").equalTo(telefone).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    edttelefone.setTextColor(Color.RED);
                    Toast.makeText(registerActivity.this, "Telefone já existe", Toast.LENGTH_LONG).show();
                } else {
                    edttelefone.setTextColor(Color.BLACK);
                    cadastrarUsuario();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(registerActivity.this, "Erro ao verificar o telefone", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cadastrarUsuario() {
        autenticacao = ConfiguraBd.Firebaseautenticacao();

        autenticacao.createUserWithEmailAndPassword(
                cliente.getEmail(), cliente.getPassword()
        ).addOnCompleteListener(registerActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    cliente.setId(autenticacao.getCurrentUser().getUid());
                    String senhaCriptografada = criptografarSenha(cliente.getPassword());
                    cliente.setPassword(senhaCriptografada);

                    ClienteAutenticado.salvarClienteNoDatabase(cliente);

                    Toast.makeText(registerActivity.this, "Sucesso ao registrar Cliente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(registerActivity.this, loginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    String excecao = "";

                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        excecao = "Escreva uma senha mais forte";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Escreva um email válido";
                    } catch (FirebaseAuthUserCollisionException e) {
                        excecao = "Esta conta já existe";
                    } catch (Exception e) {
                        excecao = "Erro ao registrar Cliente" + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(registerActivity.this, excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String criptografarSenha(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void LoginHere(View view) {
        Intent intent = new Intent(registerActivity.this, loginActivity.class);
        startActivity(intent);
    }
}