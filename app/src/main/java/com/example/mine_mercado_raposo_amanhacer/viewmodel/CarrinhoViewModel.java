package com.example.mine_mercado_raposo_amanhacer.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Contact;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoViewModel extends ViewModel {

    private MutableLiveData<List<Contact>> carrinhoListLiveData = new MutableLiveData<>();
    private MutableLiveData<Double> totalLiveData = new MutableLiveData<>();

    public LiveData<List<Contact>> getCarrinhoListLiveData() {
        return carrinhoListLiveData;
    }

    public LiveData<Double> getTotalLiveData() {
        return totalLiveData;
    }

    public void setCarrinhoList(List<Contact> carrinhoList) {
        carrinhoListLiveData.setValue(carrinhoList);
        updateTotal();
    }

    public void addItemToCarrinho(Contact item) {
        List<Contact> currentList = carrinhoListLiveData.getValue();
        if (currentList == null) {
            currentList = new ArrayList<>();
        }
        currentList.add(item);
        carrinhoListLiveData.setValue(currentList);
        updateTotal();
    }

    public void removeItemFromCarrinho(Contact item) {
        List<Contact> currentList = carrinhoListLiveData.getValue();
        if (currentList != null) {
            currentList.remove(item);
            carrinhoListLiveData.setValue(currentList);
            updateTotal();
        }
    }

    private void updateTotal() {
        List<Contact> carrinhoList = carrinhoListLiveData.getValue();
        double total = calcularTotal(carrinhoList);
        totalLiveData.setValue(total);
    }

    private double calcularTotal(List<Contact> carrinhoList) {
        double total = 0.0;
        if (carrinhoList != null) {
            for (Contact contact : carrinhoList) {
                if (contact != null && contact.getLojaPrice() != null) {
                    total += Double.parseDouble(contact.getLojaPrice().replace("€", "").replace(",", ".")) * contact.getQuantity();
                }
            }
        }
        return total;
    }
}