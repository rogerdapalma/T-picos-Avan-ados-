package com.example.nutricomp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nutricomp.database.DatabaseHelper;

public class UserManager {

    private DatabaseHelper dbHelper;

    public UserManager(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Inserir novo usuário no banco de dados
    public boolean inserirUsuario(String nome, String email, String senha) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("email", email);
        values.put("senha", senha);

        long result = db.insert("Usuario", null, values);
        return result != -1;
    }

    // Inserir usuário padrão (user@user.com / user)
    public void inserirUsuarioPadrao() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Verifica se o usuário padrão já existe
        Cursor cursor = db.rawQuery("SELECT * FROM Usuario WHERE email = ?", new String[]{"user@user.com"});
        if (cursor.getCount() == 0) {
            // Se não existe, insere o usuário padrão
            ContentValues values = new ContentValues();
            values.put("nome", "Usuário Padrão");
            values.put("email", "user@user.com");
            values.put("senha", "user");
            db.insert("Usuario", null, values);
        }
        cursor.close();
    }

    // Obter usuário do banco de dados por email e senha
    public Cursor obterUsuario(String email, String senha) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Usuario WHERE email = ? AND senha = ?", new String[]{email, senha});
    }
}
