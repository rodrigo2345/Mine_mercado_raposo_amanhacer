package com.example.mine_mercado_raposo_amanhacer.data.localdatabase;

import android.content.Context;
import android.content.Intent;

import com.example.mine_mercado_raposo_amanhacer.view.activity_Arroz_Agulha_amanhecer;
import com.example.mine_mercado_raposo_amanhacer.view.activity_Poupa_Tomate_amanhecer;
import com.example.mine_mercado_raposo_amanhacer.view.activity_milho_partido_25kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_milho_partido_5kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_mistura_cereais_para_aves_25kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_mistura_cereais_para_aves_5kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_spike_racao_seca_cao_adulto_4kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_valouro_granulado_galinhas_poedeiras_30kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_valouro_granulado_galinhas_poedeiras_5kg;

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
            case "Milho Partido 25KG":
                intent = new Intent(context, activity_milho_partido_25kg.class);
                break;
            case "Valouro Granulado para Galinhas Poedeiras 30KG":
                intent = new Intent(context, activity_valouro_granulado_galinhas_poedeiras_30kg.class);
                break;
            case "Valouro Granulado para Galinhas Poedeiras 5KG":
                intent = new Intent(context, activity_valouro_granulado_galinhas_poedeiras_5kg.class);
                break;
            case "Mistura de Cereais para Aves 25KG":
                intent = new Intent(context, activity_mistura_cereais_para_aves_25kg.class);
                break;
            case "Mistura de Cereais para Aves 5KG":
                intent = new Intent(context, activity_mistura_cereais_para_aves_5kg.class);
                break;
            case "Milho Partido 5KG":
                intent = new Intent(context, activity_milho_partido_5kg.class);
                break;
            case "Spike Racao Seca de Cao Adulto 4KG":
                intent = new Intent(context, activity_spike_racao_seca_cao_adulto_4kg.class);
                break;

            default:
                break;
        }

        return intent;
    }
}