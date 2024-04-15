package com.example.mine_mercado_raposo_amanhacer.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.mine_mercado_raposo_amanhacer.R;
import com.example.mine_mercado_raposo_amanhacer.data.localdatabase.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteProductAdapter extends ArrayAdapter<ProductItem> implements Filterable {

    private List<ProductItem> productListFull;
    private List<ProductItem> productListFiltered = new ArrayList<>();
    private OnProductItemClickListener onProductItemClickListener;
    private Context context;

    public AutoCompleteProductAdapter(Context context) {
        super(context, 0);
        this.context = context;
        this.productListFull = new ArrayList<>();
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return productFilter;
    }

    @Override
    public int getCount() {
        return productListFiltered.size();
    }

    public void updateList(List<ProductItem> newList) {
        productListFull.clear();
        productListFull.addAll(newList);
        getFilter().filter("");
    }

    @Nullable
    @Override
    public ProductItem getItem(int position) {
        return productListFiltered.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_autocomplete_row, parent, false);
        }

        TextView productNameTextView = convertView.findViewById(R.id.product_name);
        TextView productCategoryTextView = convertView.findViewById(R.id.product_category);
        ImageView productImageView = convertView.findViewById(R.id.product_image);

        ProductItem product = getItem(position);
        if (product != null) {
            productNameTextView.setText(product.getProductName());
            productCategoryTextView.setText(product.getCategory());

            Glide.with(context)
                    .load(product.getFlagImage())
                    .into(productImageView);
        }
        convertView.setOnClickListener(v -> {
            if (product != null && onProductItemClickListener != null) {
                onProductItemClickListener.onProductItemClick(product);
            }
        });

        return convertView;
    }

    private Filter productFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();

            if (constraint != null) {
                String filterPattern = constraint.toString().toLowerCase().trim();
                List<ProductItem> filteredList = new ArrayList<>();

                for (ProductItem product : productListFull) {
                    if (product != null && product.getProductName() != null &&
                            (product.getProductName().toLowerCase().contains(filterPattern) ||
                                    product.getCategory().toLowerCase().contains(filterPattern))) {
                        filteredList.add(product);
                    }
                }

                filterResults.values = filteredList;
                filterResults.count = filteredList.size();
            }

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            productListFiltered = (List<ProductItem>) results.values;

            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((ProductItem) resultValue).getProductName();
        }
    };


    public void setOnProductItemClickListener(OnProductItemClickListener listener) {
        this.onProductItemClickListener = listener;
    }

    public interface OnProductItemClickListener {
        void onProductItemClick(ProductItem productItem);
    }
}