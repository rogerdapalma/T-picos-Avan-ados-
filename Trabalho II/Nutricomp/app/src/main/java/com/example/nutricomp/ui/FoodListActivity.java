package com.example.nutricomp.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
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
    private String selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        // Ativar botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        dbHelper = new DatabaseHelper(this);
        recyclerViewAlimentos = findViewById(R.id.recyclerViewAlimentos);
        searchBar = findViewById(R.id.searchBar);

        selectedCategory = getIntent().getStringExtra("categoria");

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
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Voltar à tela anterior
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void carregarAlimentos(String query, String categoria) {
        alimentosList.clear();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT nome, categoria, calorias, carboidratos, proteinas, gorduras, fibras FROM Alimento WHERE nome LIKE ? AND categoria = ?",
                new String[]{"%" + query + "%", categoria});

        if (cursor.moveToFirst()) {
            do {
                Food alimento = new Food(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getFloat(2),
                        cursor.getFloat(3),
                        cursor.getFloat(4),
                        cursor.getFloat(5),
                        cursor.getFloat(6)
                );
                alimentosList.add(alimento);
            } while (cursor.moveToNext());
        }
        cursor.close();

        foodAdapter = new FoodAdapter(this, alimentosList);
        recyclerViewAlimentos.setAdapter(foodAdapter);
    }
}
