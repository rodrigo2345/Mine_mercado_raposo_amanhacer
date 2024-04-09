package com.example.mine_mercado_raposo_amanhacer.data.localdatabase;

import android.content.Context;
import android.content.Intent;

import com.example.mine_mercado_raposo_amanhacer.view.activity_Arroz_Agulha_amanhecer;
import com.example.mine_mercado_raposo_amanhacer.view.activity_Poupa_Tomate_amanhecer;

public class ProductItem {

    private int id;
    private String productName;
    private String flagImage;

    public ProductItem(int id, String productName, String flagImage) {
        this.id = id;
        this.productName = productName;
        this.flagImage = flagImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }

    public String getFlagImage() {
        return flagImage;
    }

    @Override
    public String toString() {
        return "RestaurantItem{" +
                "id=" + id +
                ", ProductName='" + productName + '\'' +
                ", flagImage='" + flagImage + '\'' +
                '}';
    }

    public Intent getIntentForProduct(Context context) {
        Intent intent = new Intent();

        switch (productName) {
            case "Arroz Agulha AMACHECER":
                intent = new Intent(context, activity_Arroz_Agulha_amanhecer.class);
                break;
            case "Poupa de Tomate AMACHECER":
                intent = new Intent(context, activity_Poupa_Tomate_amanhecer.class);
                break;
            default:
                break;
        }

        return intent;
    }
}