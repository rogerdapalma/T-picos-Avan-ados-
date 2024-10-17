package com.example.nutricomp.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutricomp.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCategories;
    private CategoryAdapter categoryAdapter;

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

        // Ativar botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerViewCategories = findViewById(R.id.recyclerViewCategories);
        recyclerViewCategories.setLayoutManager(new LinearLayoutManager(this));

        categoryAdapter = new CategoryAdapter(this, categories);
        recyclerViewCategories.setAdapter(categoryAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Voltar à tela anterior
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
