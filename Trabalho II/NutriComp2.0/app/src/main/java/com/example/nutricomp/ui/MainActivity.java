package com.example.nutricomp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutricomp.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCategories;
    private CategoryAdapter categoryAdapter;

    // Categorias com nomes e seus ícones correspondentes
    private final String[] categories = {
            "Cereais e derivados",
            "Frutas e derivados",
            "Alimentos preparados",
            "Gorduras e óleos",
            "Pescados e frutos do mar",
            "Carnes e derivados",
            "Leite e derivados",
            "Miscelâneas",
            "Bebidas (alcoólicas e não alcoólicas)",
            "Ovos e derivados",
            "Produtos açucarados",
            "Verduras, hortaliças e derivados",
            "Outros alimentos industrializados",
            "Leguminosas e derivados",
            "Nozes e sementes"
    };

    private final int[] icons = {
            R.drawable.cereais_derivados,
            R.drawable.frutas_derivados,
            R.drawable.alimentos_preparados,
            R.drawable.gorduras_oleos,
            R.drawable.pescas,
            R.drawable.carne_derivados,
            R.drawable.leite_derivados,
            R.drawable.miscel_neas,
            R.drawable.bebidas,
            R.drawable.ovo_derivados,
            R.drawable.doces,
            R.drawable.verduras_derivados,
            R.drawable.industrializados,
            R.drawable.leguminosos,
            R.drawable.nozes_graos
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Habilitar o botão de voltar na barra de ação
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerViewCategories = findViewById(R.id.recyclerViewCategories);

        // Configurando o RecyclerView com um LinearLayoutManager
        recyclerViewCategories.setLayoutManager(new LinearLayoutManager(this));

        // Inicializando o adaptador com ícones
        categoryAdapter = new CategoryAdapter(this, categories, icons, category -> {
            Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
            intent.putExtra("categoria", category);
            startActivity(intent);
        });

        recyclerViewCategories.setAdapter(categoryAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Voltar à tela anterior
        onBackPressed();
        return true;
    }
}
