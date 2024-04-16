package com.example.mine_mercado_raposo_amanhacer.data.localdatabase;

import android.content.Context;
import android.content.Intent;

import com.example.mine_mercado_raposo_amanhacer.produtos.activity_Arroz_Agulha_amanhecer;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_Bolo_forma_amendoa;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_Poupa_Tomate_amanhecer;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_avenal_basic_racao_seca_cao_adulto_20kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_avenal_racao_seca_gato_cereais_carne_20kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_avenal_racao_seca_gato_cereais_carne_2kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_avenal_racao_seca_gato_cereais_carne_4kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_avenal_racao_seca_gato_peixe_2kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_bacon_fumado_extra_pedacos_probar_190GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_bacon_nacos_200GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_bacon_primor_nacos_200GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_banha_porco_235GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_bolo_forma_laranja;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_bolo_forma_mel;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_bolo_forma_noz;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_broas_mel;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_campofrio_fiambre_peru_finissimo_FT;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_casca_ostra_1KG;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_cerveja_sem_alcool_super_bock_33CL;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_chourico_carne_porco_branco_PB;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_chourico_carne_porco_preto_PP;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_chourico_grosso_porco_branco_estremoz;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_chourico_grosso_porco_preto_estremoz;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_esses_azeite;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_farinheira_branca_porco_branco;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_fiambre_frango_FT_classicas_90GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_fiambre_pa_200GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_fiambre_peito_peru_forno_lenha_120GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_garrafa_butano_13KG_rubis;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_garrafa_cepsa;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_garrafa_tuti_11KG;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_garrafa_tuti_13KG;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_gato_mousse_purina_gourmet;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_linguica_Porco_alentejano_180GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_linguica_alentejana_180GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_milho_partido_25kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_milho_partido_5kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_mistura_cereais_para_aves_25kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_mistura_cereais_para_aves_5kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_morcela_porco_branco;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_nobre_chouricao_FT_100GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_nobre_fiambre_fatias_finas_100GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_nobre_paio_york_FT_90GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_nobre_presunto_fatiado_70GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_painho_porco_preto_300GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_pepsi_regular;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_peru_frango_purina_friskies;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_presunto_duroc_nacos_primor_300GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_presunto_serrano_cura_FT_200GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_probar_bacon_fumado_fatiado_75GR;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_racao_pintos_104_valouro_5KG;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_racao_seca_gato_friskies_4kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_salame_fatiado;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_spike_racao_seca_cao_adulto_4kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_spike_racao_seca_cao_junior_4kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_sumo_amigo_morango_200ML;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_toucinho_pedacos_sal_montanheira;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_valouro_granulado_galinhas_poedeiras_30kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_valouro_granulado_galinhas_poedeiras_5kg;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_milho_inteiro_5KG;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_mistura_canarios_1KG;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_fiambre_perna_economico;

public class ProductItem {

    private int id;
    private String productName;
    private String flagImage;
    private String category;
    private String subcategory;

    public ProductItem(int id, String productName, String flagImage, String category, String subcategory) {
        this.id = id;
        this.productName = productName;
        this.flagImage = flagImage;
        this.category = category;
        this.subcategory = subcategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
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
        return "ProductItem{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", flagImage='" + flagImage + '\'' +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                '}';
    }
    public Intent getIntentForProduct(Context context) {
        Intent intent = new Intent();

        switch (productName) {
            case "Arroz Agulha":
                intent = new Intent(context, activity_Arroz_Agulha_amanhecer.class);
                break;
            case "Poupa de Tomate":
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
            case "Bacon Fumado Extra Pedacos Probar 190GR":
                intent = new Intent(context, activity_bacon_fumado_extra_pedacos_probar_190GR.class);
                break;
            case "Fiambre Frango FT Classicas 90GR":
                intent = new Intent(context, activity_fiambre_frango_FT_classicas_90GR.class);
                break;
            case "Presunto Serrano 9 Meses Cura FT 200GR":
                intent = new Intent(context, activity_presunto_serrano_cura_FT_200GR.class);
                break;
            case "Linguica Porco Alentejano 180GR":
                intent = new Intent(context, activity_linguica_Porco_alentejano_180GR.class);
                break;
            case "Banha de Porco 235GR":
                intent = new Intent(context, activity_banha_porco_235GR.class);
                break;
            case "Campofrio Fiambre Peru Finissimo FT":
                intent = new Intent(context, activity_campofrio_fiambre_peru_finissimo_FT.class);
                break;
            case "Painho Porco Preto 300GR":
                intent = new Intent(context, activity_painho_porco_preto_300GR.class);
                break;
            case "Linguica Alentejana 180GR":
                intent = new Intent(context, activity_linguica_alentejana_180GR.class);
                break;
            case "Fiambre da Pa 200GR":
                intent = new Intent(context, activity_fiambre_pa_200GR.class);
                break;
            case "Racao Pintos Iniciacao 104 Mic.Valouro 5KG":
                intent = new Intent(context, activity_racao_pintos_104_valouro_5KG.class);
                break;
            case "Milho Inteiro 5KG":
                intent = new Intent(context, activity_milho_inteiro_5KG.class);
                break;
            case "Mistura para Canarios 1KG":
                intent = new Intent(context, activity_mistura_canarios_1KG.class);
                break;
            case "Casca de Ostra 1KG":
                intent = new Intent(context, activity_casca_ostra_1KG.class);
                break;
            case "Fiambre Perna FT Economico":
                intent = new Intent(context, activity_fiambre_perna_economico.class);
                break;
            case "Bacon Probar Nacos Boa Escolha 200GR":
                intent = new Intent(context, activity_bacon_nacos_200GR.class);
                break;
            case "Pepsi Regular 1,75LT":
                intent = new Intent(context, activity_pepsi_regular.class);
                break;
            case "Sumo Amigo de Morango 200ML":
                intent = new Intent(context, activity_sumo_amigo_morango_200ML.class);
                break;
            case "Garrafa Cepsa 12,5KG":
                intent = new Intent(context, activity_garrafa_cepsa.class);
                break;
            case "Garrafa Tuti 11KG":
                intent = new Intent(context, activity_garrafa_tuti_11KG.class);
                break;
            case "Garrafa Tuti 13KG":
                intent = new Intent(context, activity_garrafa_tuti_13KG.class);
                break;
            case "Garrafa Butano 13KG Rubis":
                intent = new Intent(context, activity_garrafa_butano_13KG_rubis.class);
                break;
            case "Cerveja Sem Alcool Super Bock 33CL":
                intent = new Intent(context, activity_cerveja_sem_alcool_super_bock_33CL.class);
                break;
            case "Bolo Forma de Mel":
                intent = new Intent(context, activity_bolo_forma_mel.class);
                break;
            case "Bolo Forma de Amendoa":
                intent = new Intent(context, activity_Bolo_forma_amendoa.class);
                break;
            case "Bolo Forma de Laranja":
                intent = new Intent(context, activity_bolo_forma_laranja.class);
                break;
            case "Bolo Forma de Noz":
                intent = new Intent(context, activity_bolo_forma_noz.class);
                break;
            case "Broas de Mel":
                intent = new Intent(context, activity_broas_mel.class);
                break;
            case "Esses de Azeite":
                intent = new Intent(context, activity_esses_azeite.class);
                break;
            case "Salame Fatiado":
                intent = new Intent(context, activity_salame_fatiado.class);
                break;
            case "Queijada de Requeijao":
                intent = new Intent(context, activity_queijada_requeijao.class);
                break;
            case "Folar de Mel":
                intent = new Intent(context, activity_folar_Mel.class);
                break;
            default:
                break;
        }

        return intent;
    }
}