package com.example.nutricomp.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutricomp.R;
import com.example.nutricomp.ui.FoodListActivity;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private final String[] categories;
    // private final int[] icons;  // Ícones comentados
    private final Context context;

    public CategoryAdapter(Context context, String[] categories /*, int[] icons*/) {
        this.context = context;
        this.categories = categories;
        // this.icons = icons;  // Ícones comentados
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
        // Comentando a linha que define o ícone
        // holder.imageViewIcon.setImageResource(icons[position]);

        // Configurando o clique para abrir a lista de alimentos com base na categoria selecionada
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodListActivity.class);
            intent.putExtra("categoria", categories[position]); // Passa a categoria selecionada para a próxima activity
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        ImageView imageViewIcon;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
            // Comentando a exibição do ícone
            // imageViewIcon.setVisibility(View.GONE);
        }
    }
}
