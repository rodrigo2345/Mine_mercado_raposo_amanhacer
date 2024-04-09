package com.example.mine_mercado_raposo_amanhacer.data.localdatabase;

import java.util.List;

public class Pedido {
    private String pedidoId;
    private String userId;
    private List<Contact> carrinhoList;
    private double total;
    private String nomeCliente;
    private String metodoPagamento;
    private String morada;
    private String telefone;

    public Pedido(String userId, List<Contact> carrinhoList, double total, String nomeCliente, String metodoPagamento, String morada, String telefone) {
        this.userId = userId;
        this.carrinhoList = carrinhoList;
        this.total = total;
        this.nomeCliente = nomeCliente;
        this.metodoPagamento = metodoPagamento;
        this.morada = morada;
        this.telefone = telefone;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Contact> getCarrinhoList() {
        return carrinhoList;
    }

    public void setCarrinhoList(List<Contact> carrinhoList) {
        this.carrinhoList = carrinhoList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método para calcular a quantidade total de produtos no pedido
    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (Contact contact : carrinhoList) {
            totalQuantity += contact.getQuantity();
        }
        return totalQuantity;
    }
}
