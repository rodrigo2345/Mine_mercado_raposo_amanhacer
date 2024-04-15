package com.example.mine_mercado_raposo_amanhacer.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Contact;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.ProductItem;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.ProductService;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class PesquisaActivity extends AppCompatActivity {

    private List<ProductItem> productList = new ArrayList<>();
    private AutoCompleteProductAdapter autoCompleteAdapter;
    private Spinner categorySpinner;
    private String selectedCategory = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        categorySpinner = findViewById(R.id.category_spinner);
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this, R.array.categories_array, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String newlySelectedCategory = adapterView.getItemAtPosition(position).toString();
                if (!newlySelectedCategory.equalsIgnoreCase(selectedCategory)) {
                    selectedCategory = newlySelectedCategory;
                    if (selectedCategory.equalsIgnoreCase("Bebidas")) {
                        showSubcategoriesDialog(R.array.subcategories_bebidas_array);
                    } else if (selectedCategory.equalsIgnoreCase("Alimento de Animais")) {
                        showSubcategoriesDialog(R.array.subcategories_alimento_animais_array);
                    }
                    else {
                        filterProductsAndUpdateList("");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedCategory = "";
                filterProductsAndUpdateList("");
            }
        });

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.actv);
        autoCompleteAdapter = new AutoCompleteProductAdapter(this);
        autoCompleteTextView.setAdapter(autoCompleteAdapter);

        fetchProductsFromAPI();

        WebView webView = findViewById(R.id.webView2);
        String video = "<html><body style=\"margin:0;padding:0;\"><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lVOuaU44bKk?si=nVnAjkRGwhljesgK\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        webView.loadData(video, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        autoCompleteAdapter.setOnProductItemClickListener(productItem -> openProductClassification(productItem));
    }

    private void showSubcategoriesDialog(int subcategoriesArrayId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecione uma subcategoria");
        ArrayAdapter<CharSequence> subcategoryAdapter = ArrayAdapter.createFromResource(this, subcategoriesArrayId, android.R.layout.simple_spinner_item);
        builder.setAdapter(subcategoryAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String selectedSubcategory = subcategoryAdapter.getItem(i).toString();
                filterProductsAndUpdateList(selectedSubcategory);
            }
        });
        builder.create().show();
    }

    private void fetchProductsFromAPI() {
        ProductService service = RetrofitClientInstance.getRetrofitInstance().create(ProductService.class);
        Call<List<ProductItem>> call = service.getProduct();

        call.enqueue(new Callback<List<ProductItem>>() {
            @Override
            public void onResponse(Call<List<ProductItem>> call, Response<List<ProductItem>> response) {
                if (response.isSuccessful()) {
                    productList = response.body();
                    filterProductsAndUpdateList("");
                    Toast.makeText(PesquisaActivity.this, "Produtos atualizados com sucesso", Toast.LENGTH_SHORT).show();
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

    private void filterProductsAndUpdateList(String filter) {
        if (TextUtils.isEmpty(filter)) {
            if (selectedCategory.equalsIgnoreCase("Todos")) {
                autoCompleteAdapter.updateList(productList);
            } else {
                List<ProductItem> filteredList = new ArrayList<>();
                for (ProductItem product : productList) {
                    if (product.getCategory() != null && product.getCategory().equalsIgnoreCase(selectedCategory)) {
                        filteredList.add(product);
                    }
                }
                autoCompleteAdapter.updateList(filteredList);
            }
        } else {
            List<ProductItem> filteredList = new ArrayList<>();
            for (ProductItem product : productList) {
                if (product.getCategory() != null && product.getCategory().equalsIgnoreCase(selectedCategory)
                        && product.getSubcategory() != null && product.getSubcategory().equalsIgnoreCase(filter)) {
                    filteredList.add(product);
                }
            }
            autoCompleteAdapter.updateList(filteredList);
        }
    }

    private void openProductClassification(ProductItem product) {
        Intent intent = product.getIntentForProduct(this);
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = new Intent(PesquisaActivity.this, MainActivity.class);
        startActivity(intent);
    }
}