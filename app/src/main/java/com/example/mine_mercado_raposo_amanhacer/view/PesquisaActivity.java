package com.example.mine_mercado_raposo_amanhacer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Contact;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.ProductItem;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.ProductService;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PesquisaActivity extends AppCompatActivity {

    private List<ProductItem> productList = new ArrayList<>();
    private List<ProductItem> filteredProductList = new ArrayList<>();
    private AutoCompleteProductAdapter autoCompleteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.actv);
        autoCompleteAdapter = new AutoCompleteProductAdapter(this);
        autoCompleteTextView.setAdapter(autoCompleteAdapter);
        fetchRestaurantsFromAPI();
        WebView webView = findViewById(R.id.webView2);
        String video = "<html><body style=\"margin:0;padding:0;\"><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lVOuaU44bKk?si=nVnAjkRGwhljesgK\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        webView.loadData(video, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        autoCompleteAdapter.setOnProductItemClickListener(productItem -> {
            openProductClassification(productItem);
        });

    }

    private void fetchRestaurantsFromAPI() {
        ProductService service = RetrofitClientInstance.getRetrofitInstance().create(ProductService.class);
        Call<List<ProductItem>> call = service.getProduct();
        Call<List<ProductItem>> call2 = service.deleteProduct();
        Call<List<ProductItem>> call3 = service.addProduct();
        Call<List<ProductItem>> call4 = service.updateProduct();

        call.enqueue(new Callback<List<ProductItem>>() {
            @Override
            public void onResponse(Call<List<ProductItem>> call, Response<List<ProductItem>> response) {
                if (response.isSuccessful()) {
                    productList = response.body();
                    Toast.makeText(PesquisaActivity.this, "Api ligada com sucesso", Toast.LENGTH_SHORT).show();
                    autoCompleteAdapter.updateList(productList);
                } else {
                    Toast.makeText(PesquisaActivity.this, "Falha ao obter dados da API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ProductItem>> call, Throwable t) {
                Toast.makeText(PesquisaActivity.this, "Erro de conexão: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openProductClassification(ProductItem product) {
        Intent intent = product.getIntentForProduct(this);
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = (new Intent(PesquisaActivity.this, MainActivity.class));
        startActivity(intent);
    }
}

