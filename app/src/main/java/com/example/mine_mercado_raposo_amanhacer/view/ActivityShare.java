package com.example.mine_mercado_raposo_amanhacer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mine_mercado_raposo_amanhacer.R;

public class ActivityShare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
    }
    public void Home(View view) {
        Intent intent = (new Intent(ActivityShare.this, MainActivity.class));
        startActivity(intent);
    }
    public void Search(View view) {
        Intent intent = new Intent(ActivityShare.this, PesquisaActivity.class);
        startActivity(intent);
    }
}