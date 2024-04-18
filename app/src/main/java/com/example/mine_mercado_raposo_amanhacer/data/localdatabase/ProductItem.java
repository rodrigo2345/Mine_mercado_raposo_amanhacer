package com.example.mine_mercado_raposo_amanhacer.data.localdatabase;

import android.content.Context;
import android.content.Intent;

import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_adubo_azul_quimirraia_1KG;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_balde_2Lt_tampa_Popcorn;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_balde_tampa_5_5_LT;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_cacarola_aluminio_n20_orbita;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_cacarola_aluminio_n22_orbita;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_cafeteira_inox_ibiza_hoyca_1lt;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_chinelos;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_enleia_polietileno_3mm_branca_rl_corda;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_escova_limpa_sanitas_piassaba_branco;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_esponja_banho_mg127_tabomil;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_feijao_verde_rasteiro_patareco;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_fritadeira_rede_esmalte_24cm_orbita;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_insecticida_formigas_bio_fortana_100gr;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_jogo_cama_2_40MTS;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_jogo_cama_905_MTS;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_lenco_papel_branco_3f_6un;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_limacide_250gr_caracois;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_oleo_cedro_SP_mistolin_360ML;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_papel_higienico_2f_domestico_compacto_amoos;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_passadeira_belga_C_Debrum_Poliamida;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_porta_escova_limpa_sanitas_piassaba_branco;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_prato_branco_ebro;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_raid_moscas_mosquitos_accion_fulminante_400ML;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_saco_lixo_ecolixo_50lt;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_saco_pinhas_inflame_3KG;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_semente_feijao_trepar_algarve;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_tapete_floral_polipropileno;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_tela_laminada_brilho_estampada_3d3;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_tela_laminada_brilho_estampada_5h3;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_tinta_branca_ecomat_quimirraia_5LT;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_tinta_branca_sorcor_quimirraia_5LT;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_trincha_junior;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_vaso_castanho;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_vaso_castanho_prato;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_vaso_prato_terracota_castanho;
import com.example.mine_mercado_raposo_amanhacer.Bazar.activity_velas_iluminacao_v7_lumar;
import com.example.mine_mercado_raposo_amanhacer.Pastelaria.activity_Bolo_forma_amendoa;
import com.example.mine_mercado_raposo_amanhacer.Pastelaria.activity_bolo_forma_laranja;
import com.example.mine_mercado_raposo_amanhacer.Pastelaria.activity_bolo_forma_mel;
import com.example.mine_mercado_raposo_amanhacer.Pastelaria.activity_bolo_forma_noz;
import com.example.mine_mercado_raposo_amanhacer.Pastelaria.activity_broas_mel;
import com.example.mine_mercado_raposo_amanhacer.Pastelaria.activity_esses_azeite;
import com.example.mine_mercado_raposo_amanhacer.Pastelaria.activity_folar_Mel;
import com.example.mine_mercado_raposo_amanhacer.Pastelaria.activity_queijada_requeijao;
import com.example.mine_mercado_raposo_amanhacer.Pastelaria.activity_salame_fatiado;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_avenal_basic_racao_seca_cao_adulto_20kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_avenal_racao_seca_gato_cereais_carne_20kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_avenal_racao_seca_gato_cereais_carne_2kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_avenal_racao_seca_gato_cereais_carne_4kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_avenal_racao_seca_gato_peixe_2kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_casca_ostra_1KG;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_gato_mousse_purina_gourmet;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_milho_inteiro_5KG;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_milho_partido_25kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_milho_partido_5kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_mistura_canarios_1KG;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_mistura_cereais_para_aves_25kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_mistura_cereais_para_aves_5kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_peru_frango_purina_friskies;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_racao_pintos_104_valouro_5KG;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_racao_seca_gato_friskies_4kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_spike_racao_seca_cao_adulto_4kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_spike_racao_seca_cao_junior_4kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_valouro_granulado_galinhas_poedeiras_30kg;
import com.example.mine_mercado_raposo_amanhacer.alimento_de_animais.activity_valouro_granulado_galinhas_poedeiras_5kg;
import com.example.mine_mercado_raposo_amanhacer.bebidas.activity_sumo_amigo_morango_200ML;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_toucinho_pedacos_sal_montanheira;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_bife_porco;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_carapau_grande_congelado_granel;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_cavala_grande_granel;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_chispe_porco;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_costeleta_cachaco_porco;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_entremeada_porco_fatiada;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_febra_guisar_porco;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_filete_pescada_comdalgel_cong;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_frango_carne_congelado_e;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_hamburger_peru_avibom_3un;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_lombos_bacalhau_pescanova_cong;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_orelha_porco_congelada_saco_2un;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_peixe_espada_branco_posta;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_perca_nilo_posta;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_pescada_posta_congelada_higien;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_red_fish_medio_hig;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_sardinha_congelada_granel;
import com.example.mine_mercado_raposo_amanhacer.congelados.activity_sardinha_pequena_petinga_congelada_granel;
import com.example.mine_mercado_raposo_amanhacer.produtos.activity_Arroz_Agulha_amanhecer;
import com.example.mine_mercado_raposo_amanhacer.bebidas.activity_cerveja_sem_alcool_super_bock_33CL;
import com.example.mine_mercado_raposo_amanhacer.bebidas.activity_pepsi_regular;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_bacon_fumado_extra_pedacos_probar_190GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_bacon_nacos_200GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_bacon_primor_nacos_200GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_banha_porco_235GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_campofrio_fiambre_peru_finissimo_FT;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_chourico_carne_porco_branco_PB;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_chourico_carne_porco_preto_PP;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_chourico_grosso_porco_branco_estremoz;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_chourico_grosso_porco_preto_estremoz;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_farinheira_branca_porco_branco;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_fiambre_frango_FT_classicas_90GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_fiambre_pa_200GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_fiambre_peito_peru_forno_lenha_120GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_fiambre_perna_economico;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_linguica_Porco_alentejano_180GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_linguica_alentejana_180GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_morcela_porco_branco;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_nobre_chouricao_FT_100GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_nobre_fiambre_fatias_finas_100GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_nobre_paio_york_FT_90GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_nobre_presunto_fatiado_70GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_painho_porco_preto_300GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_presunto_duroc_nacos_primor_300GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_presunto_serrano_cura_FT_200GR;
import com.example.mine_mercado_raposo_amanhacer.charcutaria.activity_probar_bacon_fumado_fatiado_75GR;
import com.example.mine_mercado_raposo_amanhacer.gas.activity_garrafa_butano_13KG_rubis;
import com.example.mine_mercado_raposo_amanhacer.gas.activity_garrafa_cepsa;
import com.example.mine_mercado_raposo_amanhacer.gas.activity_garrafa_tuti_11KG;
import com.example.mine_mercado_raposo_amanhacer.gas.activity_garrafa_tuti_13KG;
import com.example.mine_mercado_raposo_amanhacer.produtos.*;

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
            case "Tapete Floral 57X3CM 100% Polipropileno":
                intent = new Intent(context, activity_tapete_floral_polipropileno.class);
                break;
            case "Saco de Pinhas Inflame 3KG":
                intent = new Intent(context, activity_saco_pinhas_inflame_3KG.class);
                break;
            case "Velas de Iluminacao V7 Lumar":
                intent = new Intent(context, activity_velas_iluminacao_v7_lumar.class);
                break;
            case "Escova Limpa Sanitas com Piassaba Branco":
                intent = new Intent(context, activity_escova_limpa_sanitas_piassaba_branco.class);
                break;
            case "Porta Escova Limpa Sanitas com Piassaba Branco":
                intent = new Intent(context, activity_porta_escova_limpa_sanitas_piassaba_branco.class);
                break;
            case "Trincha Junior 21/2":
                intent = new Intent(context, activity_trincha_junior.class);
                break;
            case "Adubo Azul Quimirraia 1KG":
                intent = new Intent(context, activity_adubo_azul_quimirraia_1KG.class);
                break;
            case "Vaso Castanho":
                intent = new Intent(context, activity_vaso_castanho.class);
                break;
            case "Vaso Castanho para Prato":
                intent = new Intent(context, activity_vaso_castanho_prato.class);
                break;
            case "Oleo de Cedro SP Mistolin 360ML":
                intent = new Intent(context, activity_oleo_cedro_SP_mistolin_360ML.class);
                break;
            case "Esponja de Banho MG127 Tabomil":
                intent = new Intent(context, activity_esponja_banho_mg127_tabomil.class);
                break;
            case "Tinta Branca Ecomat Quimirraia 5LT":
                intent = new Intent(context, activity_tinta_branca_ecomat_quimirraia_5LT.class);
                break;
            case "Tinta Branca Sorcor Quimirraia 5LT":
                intent = new Intent(context, activity_tinta_branca_sorcor_quimirraia_5LT.class);
                break;
            case "Limacide 250GR Caracois":
                intent = new Intent(context, activity_limacide_250gr_caracois.class);
                break;
            case "Saco Lixo Ecolixo 50LT":
                intent = new Intent(context, activity_saco_lixo_ecolixo_50lt.class);
                break;
            case "Balde 2LT com Tampa Popcorn/250":
                intent = new Intent(context, activity_balde_2Lt_tampa_Popcorn.class);
                break;
            case "Vaso e Prato Terracota Castanho":
                intent = new Intent(context, activity_vaso_prato_terracota_castanho.class);
                break;
            case "Papel Higienico 2F Domestico Compacto 12=24 P96R Amoos":
                intent = new Intent(context, activity_papel_higienico_2f_domestico_compacto_amoos.class);
                break;
            case "Cafeteira Inox Ibiza Hoyca 1LT":
                intent = new Intent(context, activity_cafeteira_inox_ibiza_hoyca_1lt.class);
                break;
            case "Cacarola de Aluminio n20 Orbita":
                intent = new Intent(context, activity_cacarola_aluminio_n20_orbita.class);
                break;
            case "Cacarola de Aluminio n22 Orbita":
                intent = new Intent(context, activity_cacarola_aluminio_n22_orbita.class);
                break;
            case "Fritadeira com Rede Esmalte 24CM Orbita":
                intent = new Intent(context, activity_fritadeira_rede_esmalte_24cm_orbita.class);
                break;
            case "Tela Laminada Brilho Estampada 3D3/10 100%PVC":
                intent = new Intent(context, activity_tela_laminada_brilho_estampada_3d3.class);
                break;
            case "Tela Laminada Brilho Estampada 5H3/01 100%PVC":
                intent = new Intent(context, activity_tela_laminada_brilho_estampada_5h3.class);
                break;
            case "Enleia Polietileno 3MM Branca RL Corda":
                intent = new Intent(context, activity_enleia_polietileno_3mm_branca_rl_corda.class);
                break;
            case "Passadeira Belga C/Debrum 100%Poliamida":
                intent = new Intent(context, activity_passadeira_belga_C_Debrum_Poliamida.class);
                break;
            case "Jogo de Cama 100% 01 2,40MTS":
                intent = new Intent(context, activity_jogo_cama_2_40MTS.class);
                break;
            case "Jogo de Cama 100% 01 REF 905":
                intent = new Intent(context, activity_jogo_cama_905_MTS.class);
                break;
            case "Lenco Papel Branco 3F 6UN":
                intent = new Intent(context, activity_lenco_papel_branco_3f_6un.class);
                break;
            case "Balde com Tampa 5,5LT":
                intent = new Intent(context, activity_balde_tampa_5_5_LT.class);
                break;
            case "Prato Branco EBRO":
                intent = new Intent(context, activity_prato_branco_ebro.class);
                break;
            case "Semente Feijao Trepar Algarve":
                intent = new Intent(context, activity_semente_feijao_trepar_algarve.class);
                break;
            case "Feijao Verde Rasteiro Patareco":
                intent = new Intent(context, activity_feijao_verde_rasteiro_patareco.class);
                break;
            case "Insecticida Po para Formigas Bio Fortana 100GR":
                intent = new Intent(context, activity_insecticida_formigas_bio_fortana_100gr.class);
                break;
            case "Raid Moscas Y Mosquitos Accion Fulminante 400ML":
                intent = new Intent(context, activity_raid_moscas_mosquitos_accion_fulminante_400ML.class);
                break;
            case "Chinelos":
                intent = new Intent(context, activity_chinelos.class);
                break;
            case "Red Fish Medio Hig":
                intent = new Intent(context, activity_red_fish_medio_hig.class);
                break;
            case "Sardinha Congelada a Granel":
                intent = new Intent(context, activity_sardinha_congelada_granel.class);
                break;
            case "Carapau Grande Congelado a Granel":
                intent = new Intent(context, activity_carapau_grande_congelado_granel.class);
                break;
            case "Pescada em Posta Congelada Higien":
                intent = new Intent(context, activity_pescada_posta_congelada_higien.class);
                break;
            case "Sardinha Pequena Petinga Congelada a Granel":
                intent = new Intent(context, activity_sardinha_pequena_petinga_congelada_granel.class);
                break;
            case "Lombos de Bacalhau Pescanova Cong":
                intent = new Intent(context, activity_lombos_bacalhau_pescanova_cong.class);
                break;
            case "Filete de Pescada Comdalgel Cong":
                intent = new Intent(context, activity_filete_pescada_comdalgel_cong.class);
                break;
            case "Cavala Grande Granel":
                intent = new Intent(context, activity_cavala_grande_granel.class);
                break;
            case "Peixe Espada Branco Posta":
                intent = new Intent(context, activity_peixe_espada_branco_posta.class);
                break;
            case "Perca do Nilo Posta":
                intent = new Intent(context, activity_perca_nilo_posta.class);
                break;
            case "Orelha de Porco Congelada Saco com 2UN":
                intent = new Intent(context, activity_orelha_porco_congelada_saco_2un.class);
                break;
            case "Costeleta Cachaco de Porco":
                intent = new Intent(context, activity_costeleta_cachaco_porco.class);
                break;
            case "Bife de Porco":
                intent = new Intent(context, activity_bife_porco.class);
                break;
            case "Febra de Guisar de Porco Rojoes":
                intent = new Intent(context, activity_febra_guisar_porco.class);
                break;
            case "Chispe de Porco":
                intent = new Intent(context, activity_chispe_porco.class);
                break;
            case "Entremeada de Porco Fatiada":
                intent = new Intent(context, activity_entremeada_porco_fatiada.class);
                break;
            case "Frango Carne Congelado E":
                intent = new Intent(context, activity_frango_carne_congelado_e.class);
                break;
            case "Hamburger Peru Avibom 3UN":
                intent = new Intent(context, activity_hamburger_peru_avibom_3un.class);
                break;
            default:
                break;
        }

        return intent;
    }
}