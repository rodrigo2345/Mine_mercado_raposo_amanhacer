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

    public Contact(String title, String lojaPrice, int restaurantImage) {
        this.title = title;
        this.lojaPrice = lojaPrice;
        this.restaurantImage = restaurantImage;
    }

    protected Contact(Parcel in) {
        title = in.readString();
        lojaPrice = in.readString();
        restaurantImage = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(lojaPrice);
        dest.writeInt(restaurantImage);
    }
}
