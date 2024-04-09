package com.example.mine_mercado_raposo_amanhacer.data.localdatabase;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {

    private String title;
    private String lojaPrice;
    private int restaurantImage;
    private int quantity; // Adicionando a quantidade

    public Contact(String title, String lojaPrice, int restaurantImage, int quantity) {
        this.title = title;
        this.lojaPrice = lojaPrice;
        this.restaurantImage = restaurantImage;
        this.quantity = quantity;
    }

    protected Contact(Parcel in) {
        title = in.readString();
        lojaPrice = in.readString();
        restaurantImage = in.readInt();
        quantity = in.readInt();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getLojaPrice() {
        return lojaPrice;
    }

    public int getRestaurantImage() {
        return restaurantImage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(lojaPrice);
        dest.writeInt(restaurantImage);
        dest.writeInt(quantity);
    }
}
