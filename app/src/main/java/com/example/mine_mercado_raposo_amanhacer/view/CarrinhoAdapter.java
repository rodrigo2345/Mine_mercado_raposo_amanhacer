package com.example.mine_mercado_raposo_amanhacer.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.Contact;
import com.google.gson.Gson;

import java.util.ArrayList;
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
        if (carrinhoList == null) {
            this.carrinhoList = new ArrayList<>();
        } else {
            this.carrinhoList = carrinhoList;
        }
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
        holder.quantityTextView.setText(String.valueOf(contact.getQuantity())); // Definindo a quantidade

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contact.setQuantity(contact.getQuantity() + 1);
                notifyDataSetChanged();
                ((CarrinhoActivity) mContext).updateTotal();
            }
        });

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newQuantity = contact.getQuantity() - 1;
                if (newQuantity >= 0) {
                    contact.setQuantity(newQuantity);
                    notifyDataSetChanged();
                    ((CarrinhoActivity) mContext).updateTotal();
                    if (newQuantity == 0) {
                        showDeleteConfirmationDialog(position);
                    }
                }
            }
        });

    }

    private void showDeleteConfirmationDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Confirmar Exclusão")
                .setMessage("Tem certeza que deseja excluir este item?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Remove o item da lista
                        carrinhoList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, getItemCount());
                        ((CarrinhoActivity) mContext).updateTotal();

                        // Atualiza e salva a lista no SharedPreferences
                        ((CarrinhoActivity) mContext).saveCarrinhoList(carrinhoList);

                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Cancela a exclusão
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public int getItemCount() {
        return carrinhoList.size();
    }

    public class CarrinhoViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView priceTextView;
        private TextView quantityTextView;
        private ImageView imageView;
        private Button btnAdd;
        private Button btnRemove;

        public CarrinhoViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewProductName);
            priceTextView = itemView.findViewById(R.id.textViewProductPrice);
            quantityTextView = itemView.findViewById(R.id.textViewProductQuantidade);
            imageView = itemView.findViewById(R.id.imageViewProduct);
            btnAdd = itemView.findViewById(R.id.btnAdicionar);
            btnRemove = itemView.findViewById(R.id.btnRemover);
        }
    }
}