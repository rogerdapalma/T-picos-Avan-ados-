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
    private EditText editTextGramas; // Campo para entrada de gramas
    private DatabaseHelper dbHelper;
    private ArrayList<Food> alimentosList;
    private FoodAdapter foodAdapter;
    private String selectedCategory; // Categoria selecionada
    private int gramas = 100; // Valor padrão de 100 gramas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        dbHelper = new DatabaseHelper(this);
        recyclerViewAlimentos = findViewById(R.id.recyclerViewAlimentos);
        searchBar = findViewById(R.id.searchBar);
        editTextGramas = findViewById(R.id.editTextGramas);

        selectedCategory = getIntent().getStringExtra("categoria");

        if (selectedCategory == null || selectedCategory.isEmpty()) {
            Toast.makeText(this, "Categoria não recebida", Toast.LENGTH_SHORT).show();
            Log.e("FoodListActivity", "Categoria não foi recebida");
            return;
        }

        alimentosList = new ArrayList<>();
        recyclerViewAlimentos.setLayoutManager(new LinearLayoutManager(this));

        carregarAlimentos("", selectedCategory);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                carregarAlimentos(s.toString(), selectedCategory);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        editTextGramas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    gramas = Integer.parseInt(s.toString());
                    if (gramas <= 0) {
                        Toast.makeText(FoodListActivity.this, "Insira um valor maior que zero", Toast.LENGTH_SHORT).show();
                        gramas = 100;
                    }
                } catch (NumberFormatException e) {
                    gramas = 100; // Padrão se entrada inválida
                }
                carregarAlimentos(searchBar.getText().toString(), selectedCategory);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void carregarAlimentos(String query, String categoria) {
        alimentosList.clear();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT nome, categoria, calorias, carboidratos, proteinas, gorduras, fibras, umidade, energia, lipideos, colesterol, cinzas, calcio, magnesio FROM Alimento WHERE nome LIKE ? AND categoria = ?",
                new String[]{"%" + query + "%", categoria});

        if (cursor.moveToFirst()) {
            do {
                Food alimento = new Food(
                        cursor.getString(0),  // nome
                        cursor.getString(1),  // categoria
                        (cursor.getFloat(2) * gramas) / 100,   // calorias
                        (cursor.getFloat(3) * gramas) / 100,   // carboidratos
                        (cursor.getFloat(4) * gramas) / 100,   // proteinas
                        (cursor.getFloat(5) * gramas) / 100,   // gorduras
                        (cursor.getFloat(6) * gramas) / 100,   // fibras
                        (cursor.getFloat(7) * gramas) / 100,   // umidade
                        (cursor.getFloat(8) * gramas) / 100,   // energia
                        (cursor.getFloat(9) * gramas) / 100,   // lipideos
                        (cursor.getFloat(10) * gramas) / 100,  // colesterol
                        (cursor.getFloat(11) * gramas) / 100,  // cinzas
                        (cursor.getFloat(12) * gramas) / 100,  // calcio
                        (cursor.getFloat(13) * gramas) / 100   // magnesio
                );
                alimentosList.add(alimento);
            } while (cursor.moveToNext());
        } else {
            Log.e("FoodListActivity", "Nenhum alimento encontrado para a categoria: " + categoria);
            Toast.makeText(this, "Nenhum alimento encontrado", Toast.LENGTH_SHORT).show();
        }

        cursor.close();

        if (foodAdapter == null) {
            foodAdapter = new FoodAdapter(this, alimentosList);
            recyclerViewAlimentos.setAdapter(foodAdapter);
        } else {
            foodAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
