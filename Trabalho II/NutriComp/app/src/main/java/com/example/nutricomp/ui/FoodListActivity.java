package com.example.nutricomp.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutricomp.R;
import com.example.nutricomp.database.DatabaseHelper;
import com.example.nutricomp.models.Food;
import com.example.nutricomp.ui.adapters.FoodAdapter;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewAlimentos;
    private EditText searchBar;
    private DatabaseHelper dbHelper;
    private ArrayList<Food> alimentosList;
    private FoodAdapter foodAdapter;
    private String selectedCategory; // Categoria selecionada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        // Habilitar o botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Inicializar componentes
        dbHelper = new DatabaseHelper(this);
        recyclerViewAlimentos = findViewById(R.id.recyclerViewAlimentos);
        searchBar = findViewById(R.id.searchBar);

        // Receber a categoria selecionada
        selectedCategory = getIntent().getStringExtra("categoria");

        if (selectedCategory == null || selectedCategory.isEmpty()) {
            Toast.makeText(this, "Categoria não recebida", Toast.LENGTH_SHORT).show();
            Log.e("FoodListActivity", "Categoria não foi recebida");
            return;
        }

        alimentosList = new ArrayList<>();
        recyclerViewAlimentos.setLayoutManager(new LinearLayoutManager(this));

        // Carregar alimentos com base na categoria selecionada
        carregarAlimentos("", selectedCategory);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Atualiza a lista conforme a pesquisa
                carregarAlimentos(s.toString(), selectedCategory);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    // Função para carregar alimentos conforme a pesquisa e categoria
    private void carregarAlimentos(String query, String categoria) {
        alimentosList.clear();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Log.d("FoodListActivity", "Carregando alimentos da categoria: " + categoria);

        // Consulta SQL para buscar alimentos
        Cursor cursor = db.rawQuery(
                "SELECT nome, categoria, calorias, carboidratos, proteinas, gorduras, fibras FROM Alimento WHERE nome LIKE ? AND categoria = ?",
                new String[]{"%" + query + "%", categoria});

        if (cursor.moveToFirst()) {
            do {
                Food alimento = new Food(
                        cursor.getString(0),  // nome
                        cursor.getString(1),  // categoria
                        cursor.getFloat(2),   // calorias
                        cursor.getFloat(3),   // carboidratos
                        cursor.getFloat(4),   // proteinas
                        cursor.getFloat(5),   // gorduras
                        cursor.getFloat(6)    // fibras
                );
                alimentosList.add(alimento);
            } while (cursor.moveToNext());
        } else {
            Log.e("FoodListActivity", "Nenhum alimento encontrado para a categoria: " + categoria);
            Toast.makeText(this, "Nenhum alimento encontrado", Toast.LENGTH_SHORT).show();
        }

        cursor.close();

        // Atualizar o adaptador
        foodAdapter = new FoodAdapter(this, alimentosList);
        recyclerViewAlimentos.setAdapter(foodAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
