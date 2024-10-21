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

    // Atualizando as categorias para português
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Habilitar o botão de voltar (Up Button) na barra de ação
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerViewCategories = findViewById(R.id.recyclerViewCategories);

        // Configurando o RecyclerView com um LinearLayoutManager
        recyclerViewCategories.setLayoutManager(new LinearLayoutManager(this));

        // Inicializando o adaptador e definindo para o RecyclerView
        categoryAdapter = new CategoryAdapter(this, categories, new CategoryAdapter.OnCategoryClickListener() {
            @Override
            public void onCategoryClick(String category) {
                // Passando a categoria para a FoodListActivity
                Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                intent.putExtra("categoria", category);
                startActivity(intent);
            }
        });
        recyclerViewCategories.setAdapter(categoryAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Este método é acionado quando o botão de voltar é clicado
        onBackPressed();  // Voltar para a atividade anterior
        return true;
    }
}
