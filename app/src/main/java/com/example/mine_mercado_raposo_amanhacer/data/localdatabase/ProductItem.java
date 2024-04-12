package com.example.mine_mercado_raposo_amanhacer.data.localdatabase;

import android.content.Context;
import android.content.Intent;

import com.example.mine_mercado_raposo_amanhacer.view.activity_Arroz_Agulha_amanhecer;
import com.example.mine_mercado_raposo_amanhacer.view.activity_Poupa_Tomate_amanhecer;
import com.example.mine_mercado_raposo_amanhacer.view.activity_avenal_basic_racao_seca_cao_adulto_20kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_avenal_racao_seca_gato_cereais_carne_20kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_avenal_racao_seca_gato_cereais_carne_2kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_avenal_racao_seca_gato_cereais_carne_4kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_avenal_racao_seca_gato_peixe_2kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_bacon_primor_nacos_200GR;
import com.example.mine_mercado_raposo_amanhacer.view.activity_chourico_carne_porco_branco_PB;
import com.example.mine_mercado_raposo_amanhacer.view.activity_chourico_carne_porco_preto_PP;
import com.example.mine_mercado_raposo_amanhacer.view.activity_chourico_grosso_porco_branco_estremoz;
import com.example.mine_mercado_raposo_amanhacer.view.activity_chourico_grosso_porco_preto_estremoz;
import com.example.mine_mercado_raposo_amanhacer.view.activity_farinheira_branca_porco_branco;
import com.example.mine_mercado_raposo_amanhacer.view.activity_fiambre_peito_peru_forno_lenha_120GR;
import com.example.mine_mercado_raposo_amanhacer.view.activity_gato_mousse_purina_gourmet;
import com.example.mine_mercado_raposo_amanhacer.view.activity_milho_partido_25kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_milho_partido_5kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_mistura_cereais_para_aves_25kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_mistura_cereais_para_aves_5kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_morcela_porco_branco;
import com.example.mine_mercado_raposo_amanhacer.view.activity_nobre_chouricao_FT_100GR;
import com.example.mine_mercado_raposo_amanhacer.view.activity_nobre_fiambre_fatias_finas_100GR;
import com.example.mine_mercado_raposo_amanhacer.view.activity_nobre_paio_york_FT_90GR;
import com.example.mine_mercado_raposo_amanhacer.view.activity_nobre_presunto_fatiado_70GR;
import com.example.mine_mercado_raposo_amanhacer.view.activity_peru_frango_purina_friskies;
import com.example.mine_mercado_raposo_amanhacer.view.activity_presunto_duroc_nacos_primor_300GR;
import com.example.mine_mercado_raposo_amanhacer.view.activity_probar_bacon_fumado_fatiado_75GR;
import com.example.mine_mercado_raposo_amanhacer.view.activity_racao_seca_gato_friskies_4kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_spike_racao_seca_cao_adulto_4kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_spike_racao_seca_cao_junior_4kg;
import com.example.mine_mercado_raposo_amanhacer.view.activity_toucinho_pedacos_sal_montanheira;
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
            case "Arroz Agulha AMANHECER":
                intent = new Intent(context, activity_Arroz_Agulha_amanhecer.class);
                break;
            case "Poupa de Tomate AMANHECER":
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
            case "Avenal Basic Racao Seca Cao Adulto 20KG":
                intent = new Intent(context, activity_avenal_basic_racao_seca_cao_adulto_20kg.class);
                break;
            case "Spike Racao Seca de Cao Junior 4KG":
                intent = new Intent(context, activity_spike_racao_seca_cao_junior_4kg.class);
                break;
            case "Avenal Racao Seca de Gato Cereais Carne 20KG":
                intent = new Intent(context, activity_avenal_racao_seca_gato_cereais_carne_20kg.class);
                break;
            case "Avenal Racao Seca de Gato Cereais Carne 2KG":
                intent = new Intent(context, activity_avenal_racao_seca_gato_cereais_carne_2kg.class);
                break;
            case "Avenal Racao Seca de Gato Peixe 2KG":
                intent = new Intent(context, activity_avenal_racao_seca_gato_peixe_2kg.class);
                break;
            case "Racao Seca de Gato Esterilizado Peru e Frango Purina Friskies 1,5KG":
                intent = new Intent(context, activity_peru_frango_purina_friskies.class);
                break;
            case "Racao Seca de Gato Friskies 4KG":
                intent = new Intent(context, activity_racao_seca_gato_friskies_4kg.class);
                break;
            case "Alimento Gato Mousse Purina Gourmet 85GR":
                intent = new Intent(context, activity_gato_mousse_purina_gourmet.class);
                break;
            case "Avenal Racao Seca de Gato Cereais Carne 4KG":
                intent = new Intent(context, activity_avenal_racao_seca_gato_cereais_carne_4kg.class);
                break;
            case "Farinheira Branca Porco Branco":
                intent = new Intent(context, activity_farinheira_branca_porco_branco.class);
                break;
            case "Morcela Porco Branco":
                intent = new Intent(context, activity_morcela_porco_branco.class);
                break;
            case "Chourico de Carne Porco Preto PP":
                intent = new Intent(context, activity_chourico_carne_porco_preto_PP.class);
                break;
            case "Toucinho Pedacos com Sal Montanheira":
                intent = new Intent(context, activity_toucinho_pedacos_sal_montanheira.class);
                break;
            case "Chourico de Carne Porco Branco PB":
                intent = new Intent(context, activity_chourico_carne_porco_branco_PB.class);
                break;
            case "Bacon Primor Nacos S Couro 200GR":
                intent = new Intent(context, activity_bacon_primor_nacos_200GR.class);
                break;
            case "Nobre Presunto Fatiado 70GR":
                intent = new Intent(context, activity_nobre_presunto_fatiado_70GR.class);
                break;
            case "Probar Bacon Fumado Fatiado 75GR":
                intent = new Intent(context, activity_probar_bacon_fumado_fatiado_75GR.class);
                break;
            case "Campofrio Fiambre Peito Peru Forno de Lenha Finas Fatiado 120GR":
                intent = new Intent(context, activity_fiambre_peito_peru_forno_lenha_120GR.class);
                break;
            case "Nobre Chouricao FT 100GR":
                intent = new Intent(context, activity_nobre_chouricao_FT_100GR.class);
                break;
            case "Nobre Paio York FT 90GR":
                intent = new Intent(context, activity_nobre_paio_york_FT_90GR.class);
                break;
            case "Nobre Fiambre Fatias Finas 100GR":
                intent = new Intent(context, activity_nobre_fiambre_fatias_finas_100GR.class);
                break;
            case "Chourico Grosso Porco Branco Estremoz":
                intent = new Intent(context, activity_chourico_grosso_porco_branco_estremoz.class);
                break;
            case "Chourico Grosso Porco Preto Estremoz":
                intent = new Intent(context, activity_chourico_grosso_porco_preto_estremoz.class);
                break;
            case "Presunto Duroc Sem Ossos Nacos Primor 300GR":
                intent = new Intent(context, activity_presunto_duroc_nacos_primor_300GR.class);
                break;
            default:
                break;
        }

        return intent;
    }
}