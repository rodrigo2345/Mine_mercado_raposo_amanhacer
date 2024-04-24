package com.example.mine_mercado_raposo_amanhacer.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mine_mercado_raposo_amanhacer.R;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {
    private final Context mContext;
    private final String[] mCategories;
    private final int[] mCategoryImages; // Array de IDs de imagem para cada categoria

    public CustomSpinnerAdapter(Context context, int resource, String[] categories, int[] categoryImages) {
        super(context, resource, categories);
        mContext = context;
        mCategories = categories;
        mCategoryImages = categoryImages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    private View createView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_item_layout, parent, false);

        TextView textView = row.findViewById(R.id.category_text);
        ImageView imageView = row.findViewById(R.id.category_image);

        textView.setText(mCategories[position]);
        imageView.setImageResource(mCategoryImages[position]);

        return row;
    }
}
