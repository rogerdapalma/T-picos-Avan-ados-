package com.example.nutricomp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "nutricomp.db";
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

        String CREATE_TABLE_COMPARATIVO = "CREATE TABLE Comparativo (" +
                "idcomparativo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "idusuario INTEGER, " +
                "idalimento1 INTEGER, " +
                "idalimento2 INTEGER, " +
                "data TEXT, " +
                "quantidadeporgramas INTEGER, " +
                "FOREIGN KEY(idusuario) REFERENCES Usuario(idusuario), " +
                "FOREIGN KEY(idalimento1) REFERENCES Alimento(idalimento), " +
                "FOREIGN KEY(idalimento2) REFERENCES Alimento(idalimento))";

        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL(CREATE_TABLE_ALIMENTO);
        db.execSQL(CREATE_TABLE_COMPARATIVO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuario");
        db.execSQL("DROP TABLE IF EXISTS Alimento");
        db.execSQL("DROP TABLE IF EXISTS Comparativo");
        onCreate(db);
    }
}
