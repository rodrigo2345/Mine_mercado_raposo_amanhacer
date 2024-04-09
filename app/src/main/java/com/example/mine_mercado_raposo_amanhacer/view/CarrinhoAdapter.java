package com.example.mine_mercado_raposo_amanhacer.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Contact;
import com.google.gson.Gson;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder> {
    private List<Contact> carrinhoList;
    private Context mContext;

    public CarrinhoAdapter(Context context, List<Contact> carrinhoList) {
        this.mContext = context;
        this.carrinhoList = carrinhoList;
    }

    @NonNull
    @Override
    public CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrinho, parent, false);
        return new CarrinhoViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Contact contact = carrinhoList.get(position);
        holder.titleTextView.setText(contact.getTitle());
        holder.priceTextView.setText(contact.getLojaPrice());
        holder.imageView.setImageResource(contact.getRestaurantImage());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDeleteConfirmationDialog(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        if (carrinhoList != null) {
            return carrinhoList.size();
        } else {
            return 0;
        }
    }

    private void showDeleteConfirmationDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Remover item");
        builder.setMessage("Tem certeza de que deseja remover este item do carrinho?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                removeFromCart(position);
            }
        });
        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    public void removeFromCart(int position) {
        carrinhoList.remove(position);
        notifyDataSetChanged();
        saveCartToSharedPreferences();
        Toast.makeText(mContext, "Item removido do carrinho", Toast.LENGTH_SHORT).show();

        ((CarrinhoActivity) mContext).updateTotal();
    }

    private void saveCartToSharedPreferences() {
        SharedPreferences preferences = mContext.getSharedPreferences("Carrinho", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(carrinhoList);
        editor.putString("carrinhoList", json);
        editor.apply();
    }

    public class CarrinhoViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView priceTextView;
        private ImageView imageView;

        public CarrinhoViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewProductName);
            priceTextView = itemView.findViewById(R.id.textViewProductPrice);
            imageView = itemView.findViewById(R.id.imageViewProduct);
        }
    }
}