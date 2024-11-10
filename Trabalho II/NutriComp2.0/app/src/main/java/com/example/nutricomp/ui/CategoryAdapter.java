package com.example.nutricomp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutricomp.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private final String[] categories;
    private final int[] icons;  // Array para os ícones das categorias
    private final Context context;
    private final OnCategoryClickListener listener;

    public CategoryAdapter(Context context, String[] categories, int[] icons, OnCategoryClickListener listener) {
        this.context = context;
        this.categories = categories;
        this.icons = icons;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.textViewTitle.setText(categories[position]);
        holder.imageViewIcon.setImageResource(icons[position]); // Define o ícone correspondente

        holder.itemView.setOnClickListener(v -> listener.onCategoryClick(categories[position]));
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        ImageView imageViewIcon;  // Adicionado ImageView para exibir ícones

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageViewIcon = itemView.findViewById(R.id.imageViewIcon);  // Referência do ImageView
        }
    }

    // Interface para tratar o clique na categoria
    public interface OnCategoryClickListener {
        void onCategoryClick(String category);
    }
}
