package com.example.nutricomp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "nutricomp.db1";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USUARIO = "CREATE TABLE Usuario (" +
                "idusuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "email TEXT, " +
                "senha TEXT)";

        String CREATE_TABLE_ALIMENTO = "CREATE TABLE Alimento (" +
                "idalimento INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "categoria TEXT, " +
                "calorias REAL, " +
                "carboidratos REAL, " +
                "proteinas REAL, " +
                "gorduras REAL, " +
                "fibras REAL, " +
                "quantidadeporgramas INTEGER)";

        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL(CREATE_TABLE_ALIMENTO);

        // Inserir dados padrões na tabela Alimento
        inserirDadosIniciais(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuario");
        db.execSQL("DROP TABLE IF EXISTS Alimento");
        onCreate(db);
    }

    private void inserirDadosIniciais(SQLiteDatabase db) {
        // Inserir Frutas e derivados
        ContentValues values = new ContentValues();
        values.put("nome", "Maçã");
        values.put("categoria", "Frutas e derivados");
        values.put("calorias", 52);
        values.put("carboidratos", 14);
        values.put("proteinas", 0.3);
        values.put("gorduras", 0.2);
        values.put("fibras", 2.4);
        values.put("quantidadeporgramas", 100);
        db.insert("Alimento", null, values);

        values.clear();
        values.put("nome", "Banana");
        values.put("categoria", "Frutas e derivados");
        values.put("calorias", 89);
        values.put("carboidratos", 23);
        values.put("proteinas", 1.1);
        values.put("gorduras", 0.3);
        values.put("fibras", 2.6);
        values.put("quantidadeporgramas", 100);
        db.insert("Alimento", null, values);

        // Inserir Carnes e derivados
        values.clear();
        values.put("nome", "Carne bovina");
        values.put("categoria", "Carnes e derivados");
        values.put("calorias", 250);
        values.put("carboidratos", 0);
        values.put("proteinas", 26);
        values.put("gorduras", 15);
        values.put("fibras", 0);
        values.put("quantidadeporgramas", 100);
        db.insert("Alimento", null, values);

        values.clear();
        values.put("nome", "Frango");
        values.put("categoria", "Carnes e derivados");
        values.put("calorias", 239);
        values.put("carboidratos", 0);
        values.put("proteinas", 27);
        values.put("gorduras", 14);
        values.put("fibras", 0);
        values.put("quantidadeporgramas", 100);
        db.insert("Alimento", null, values);

        values.clear();
        values.put("nome", "Peixe");
        values.put("categoria", "Carnes e derivados");
        values.put("calorias", 206);
        values.put("carboidratos", 0);
        values.put("proteinas", 22);
        values.put("gorduras", 12);
        values.put("fibras", 0);
        values.put("quantidadeporgramas", 100);
        db.insert("Alimento", null, values);
    }
}
