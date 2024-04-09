package com.example.mine_mercado_raposo_amanhacer.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Contact;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

// ContactAdapter.java
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private List<Contact> contactList;
    private List<Contact> carrinhoList;
    private Context mContext;

    public ContactAdapter(Context context, List<Contact> contactList, List<Contact> carrinhoList) {
        this.mContext = context;
        this.contactList = contactList;
        if (carrinhoList == null) {
            this.carrinhoList = new ArrayList<>();
        } else {
            this.carrinhoList = carrinhoList;
        }
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended, parent, false);
        return new ContactViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.Title.setText(contact.getTitle());
        holder.RestaurantType.setText(contact.getLojaPrice());
        holder.ImageViewAvatar.setImageResource(contact.getRestaurantImage());

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(contact);
            }
        });
    }

    private void addToCart(Contact contact) {
        carrinhoList.add(contact);
        Toast.makeText(mContext, "Item adicionado ao carrinho", Toast.LENGTH_SHORT).show();

        SharedPreferences preferences = mContext.getSharedPreferences("Carrinho", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(carrinhoList);
        editor.putString("carrinhoList", json);
        editor.apply();
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private View rootView;
        private ImageView ImageViewAvatar;
        private TextView Title;
        private TextView Fee;
        private TextView RestaurantType;
        private Button addBtn;

        public ContactViewHolder(@NonNull View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.Title = rootView.findViewById(R.id.textViewProductName);
            this.RestaurantType = rootView.findViewById(R.id.textViewProductPrice);
            this.ImageViewAvatar = rootView.findViewById(R.id.imageViewProduct);
            this.addBtn = rootView.findViewById(R.id.addToCartButton);
        }
    }
}
