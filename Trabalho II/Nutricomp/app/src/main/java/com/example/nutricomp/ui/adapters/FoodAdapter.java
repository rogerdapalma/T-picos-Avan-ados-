package com.example.nutricomp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutricomp.R;
import com.example.nutricomp.models.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private Context context;
    private ArrayList<Food> foodList;

    public FoodAdapter(Context context, ArrayList<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);

        holder.textViewNome.setText(food.getNome());
        holder.textViewCategoria.setText(food.getCategoria());
        holder.textViewCalorias.setText("Calorias: " + food.getCalorias() + " kcal");
        holder.textViewCarboidratos.setText("Carboidratos: " + food.getCarboidratos() + " g");
        holder.textViewProteinas.setText("Proteínas: " + food.getProteinas() + " g");
        holder.textViewGorduras.setText("Gorduras: " + food.getGorduras() + " g");
        holder.textViewFibras.setText("Fibras: " + food.getFibras() + " g");
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNome, textViewCategoria, textViewCalorias, textViewCarboidratos, textViewProteinas, textViewGorduras, textViewFibras;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewCategoria = itemView.findViewById(R.id.textViewCategoria);
            textViewCalorias = itemView.findViewById(R.id.textViewCalorias);
            textViewCarboidratos = itemView.findViewById(R.id.textViewCarboidratos);
            textViewProteinas = itemView.findViewById(R.id.textViewProteinas);
            textViewGorduras = itemView.findViewById(R.id.textViewGorduras);
            textViewFibras = itemView.findViewById(R.id.textViewFibras);
        }
    }
}
