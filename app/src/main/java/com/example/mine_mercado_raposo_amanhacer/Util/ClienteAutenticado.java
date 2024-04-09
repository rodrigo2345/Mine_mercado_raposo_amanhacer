package com.example.mine_mercado_raposo_amanhacer.Util;

import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Cliente;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClienteAutenticado {

    public static FirebaseUser clienteLogado(){
        FirebaseAuth cliente = ConfiguraBd.Firebaseautenticacao();
        return cliente.getCurrentUser();
    }
    public static void salvarClienteNoDatabase(Cliente cliente) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("clientes");
        databaseReference.child(cliente.getId()).setValue(cliente);
    }
}
