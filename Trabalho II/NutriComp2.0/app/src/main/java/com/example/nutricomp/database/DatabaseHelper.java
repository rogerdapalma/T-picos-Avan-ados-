package com.example.nutricomp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "nutricomp.db";
    private static final int DATABASE_VERSION = 3;

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
                "umidade REAL, " +
                "energia REAL, " +
                "lipideos REAL, " +
                "colesterol REAL, " +
                "cinzas REAL, " +
                "calcio REAL, " +
                "magnesio REAL, " +
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
        inserirFrutas(db);
        inserirCarnes(db);
        inserirCereais(db);
        inserirLegumes(db);
        inserirLaticinios(db);
        inserirOvos(db);
        inserirBebidas(db);
        inserirMiscelaneas(db);
        inserirNozes(db);
        inserirProdutosAcucarados(db);
    }

    private void inserirFrutas(SQLiteDatabase db) {
        inserirAlimento(db, "Maçã", "Frutas e derivados", 52, 14, 0.3, 0.2, 2.4, 85.5, 218, 0.2, 0, 0.5, 6, 5, 100);
        inserirAlimento(db, "Banana", "Frutas e derivados", 89, 23, 1.1, 0.3, 2.6, 74.5, 371, 0.3, 0, 0.6, 5, 27, 100);
        inserirAlimento(db, "Laranja", "Frutas e derivados", 47, 12, 0.9, 0.1, 2.4, 86.5, 197, 0.1, 0, 0.4, 40, 10, 100);
        inserirAlimento(db, "Pêra", "Frutas e derivados", 57, 15, 0.4, 0.1, 3.1, 84.0, 239, 0.1, 0, 0.5, 9, 7, 100);
        inserirAlimento(db, "Uva", "Frutas e derivados", 69, 18, 0.7, 0.2, 0.9, 80.5, 288, 0.2, 0, 0.5, 10, 7, 100);
        inserirAlimento(db, "Morango", "Frutas e derivados", 32, 8, 0.7, 0.3, 2.0, 90.0, 134, 0.3, 0, 0.4, 16, 13, 100);
        inserirAlimento(db, "Abacaxi", "Frutas e derivados", 50, 13, 0.5, 0.1, 1.4, 86.0, 209, 0.1, 0, 0.3, 13, 12, 100);
        inserirAlimento(db, "Manga", "Frutas e derivados", 60, 15, 0.8, 0.4, 1.6, 83.5, 250, 0.4, 0, 0.4, 11, 10, 100);
        inserirAlimento(db, "Melancia", "Frutas e derivados", 30, 8, 0.6, 0.2, 0.4, 91.5, 127, 0.2, 0, 0.3, 7, 8, 100);
        inserirAlimento(db, "Cereja", "Frutas e derivados", 50, 12, 1.0, 0.3, 1.5, 82.0, 209, 0.3, 0, 0.5, 15, 10, 100);
        // Outros alimentos da categoria Frutas...
    }

    private void inserirCarnes(SQLiteDatabase db) {
        inserirAlimento(db, "Carne bovina", "Carnes e derivados", 250, 0, 26, 15, 0, 55.0, 1047, 15, 89, 0.9, 18, 21, 100);
        inserirAlimento(db, "Frango", "Carnes e derivados", 239, 0, 27, 14, 0, 65.0, 996, 14, 85, 0.8, 12, 24, 100);
        inserirAlimento(db, "Peixe", "Carnes e derivados", 206, 0, 22, 12, 0, 70.0, 861, 12, 63, 0.7, 10, 30, 100);
        inserirAlimento(db, "Porco", "Carnes e derivados", 242, 0, 27, 14, 0, 59.5, 1020, 14, 80, 0.8, 18, 25, 100);
        inserirAlimento(db, "Peru", "Carnes e derivados", 135, 0, 30, 2, 0, 72.0, 574, 2, 40, 0.5, 9, 15, 100);
        inserirAlimento(db, "Cordeiro", "Carnes e derivados", 294, 0, 25, 21, 0, 53.0, 1224, 21, 97, 0.9, 19, 22, 100);
        inserirAlimento(db, "Vitela", "Carnes e derivados", 172, 0, 30, 6, 0, 64.0, 720, 6, 50, 0.6, 11, 14, 100);
        inserirAlimento(db, "Lombo", "Carnes e derivados", 231, 0, 26, 14, 0, 58.0, 996, 14, 70, 0.7, 15, 20, 100);
        inserirAlimento(db, "Costela", "Carnes e derivados", 305, 0, 23, 25, 0, 49.0, 1305, 25, 105, 1.1, 22, 27, 100);
        inserirAlimento(db, "Bacon", "Carnes e derivados", 541, 1, 37, 42, 0, 40.0, 2264, 42, 125, 1.6, 8, 11, 100);
    }

    private void inserirCereais(SQLiteDatabase db) {
        inserirAlimento(db, "Arroz", "Cereais e derivados", 130, 28, 2.7, 0.3, 0.4, 11.5, 577, 0.3, 0, 0.6, 10, 35, 100);
        inserirAlimento(db, "Trigo", "Cereais e derivados", 340, 68, 13, 2.5, 10.2, 9.0, 1412, 2.5, 0, 1.8, 15, 50, 100);
        inserirAlimento(db, "Milho", "Cereais e derivados", 365, 74, 9.4, 4.7, 7.3, 10.0, 1530, 4.7, 0, 1.3, 11, 40, 100);
        inserirAlimento(db, "Cevada", "Cereais e derivados", 354, 73, 12, 2.3, 17, 12.0, 1495, 2.3, 0, 1.4, 23, 133, 100);
        inserirAlimento(db, "Aveia", "Cereais e derivados", 389, 67, 17, 7, 11, 5.0, 1627, 7.0, 0, 2.2, 52, 177, 100);
        inserirAlimento(db, "Centeio", "Cereais e derivados", 335, 74, 10, 2, 14, 11.5, 1401, 2.0, 0, 1.6, 32, 119, 100);
        inserirAlimento(db, "Quinoa", "Cereais e derivados", 368, 64, 14, 6, 7, 13.0, 1544, 6.0, 0, 2.4, 47, 197, 100);
        inserirAlimento(db, "Sorgo", "Cereais e derivados", 329, 72, 11, 3, 6, 12.0, 1382, 3.0, 0, 1.8, 13, 165, 100);
        inserirAlimento(db, "Arroz Integral", "Cereais e derivados", 111, 23, 2.6, 0.9, 1.8, 68.0, 469, 0.9, 0, 0.7, 10, 43, 100);
        inserirAlimento(db, "Farinha de Trigo", "Cereais e derivados", 364, 76, 10.3, 1, 2.7, 10.0, 1523, 1.0, 0, 0.9, 15, 34, 100);
    }

    private void inserirLegumes(SQLiteDatabase db) {
        inserirAlimento(db, "Cenoura", "Verduras, hortaliças e derivados", 35, 8, 0.6, 0.2, 3.0, 88.3, 140, 0.2, 0, 0.8, 33, 12, 100);
        inserirAlimento(db, "Tomate", "Verduras, hortaliças e derivados", 18, 4, 0.9, 0.2, 1.2, 94.5, 74, 0.2, 0, 0.5, 10, 11, 100);
        inserirAlimento(db, "Pepino", "Verduras, hortaliças e derivados", 16, 3.6, 0.7, 0.1, 0.5, 95.0, 67, 0.1, 0, 0.3, 12, 13, 100);
        inserirAlimento(db, "Pimentão", "Verduras, hortaliças e derivados", 20, 4.6, 0.9, 0.3, 1.7, 92.2, 84, 0.3, 0, 0.5, 8, 10, 100);
        inserirAlimento(db, "Alface", "Verduras, hortaliças e derivados", 14, 2.9, 1.2, 0.2, 1.1, 95.1, 59, 0.2, 0, 0.3, 19, 16, 100);
        inserirAlimento(db, "Espinafre", "Verduras, hortaliças e derivados", 23, 3.6, 2.9, 0.4, 2.2, 91.4, 97, 0.4, 0, 0.7, 99, 79, 100);
        inserirAlimento(db, "Brócolis", "Verduras, hortaliças e derivados", 34, 7, 2.8, 0.4, 2.6, 89.3, 141, 0.4, 0, 0.8, 47, 21, 100);
        inserirAlimento(db, "Couve", "Verduras, hortaliças e derivados", 33, 6.6, 3.1, 0.6, 2.8, 89.6, 137, 0.6, 0, 0.9, 72, 26, 100);
        inserirAlimento(db, "Abobrinha", "Verduras, hortaliças e derivados", 17, 3.1, 1.2, 0.3, 1.2, 94.6, 71, 0.3, 0, 0.4, 18, 15, 100);
        inserirAlimento(db, "Berinjela", "Verduras, hortaliças e derivados", 25, 5.7, 1, 0.2, 3, 92.3, 104, 0.2, 0, 0.6, 24, 14, 100);
    }

    private void inserirLaticinios(SQLiteDatabase db) {
        inserirAlimento(db, "Leite Integral", "Leite e derivados", 42, 4.9, 3.2, 1.0, 0, 88.0, 175, 1.0, 0, 0.7, 120, 10, 100);
        inserirAlimento(db, "Leite Desnatado", "Leite e derivados", 34, 5.1, 3.4, 0.1, 0, 91.0, 142, 0.1, 0, 0.5, 125, 12, 100);
        inserirAlimento(db, "Queijo Mussarela", "Leite e derivados", 280, 1.1, 22, 22, 0, 46.5, 1172, 22, 89, 3.5, 505, 20, 100);
        inserirAlimento(db, "Queijo Cheddar", "Leite e derivados", 402, 1.3, 25, 33, 0, 37.0, 1681, 33, 105, 3.9, 721, 28, 100);
        inserirAlimento(db, "Queijo Minas Frescal", "Leite e derivados", 264, 3.2, 17, 21, 0, 54.0, 1105, 21, 61, 2.8, 539, 15, 100);
        inserirAlimento(db, "Queijo Parmesão", "Leite e derivados", 431, 3.2, 38, 29, 0, 30.0, 1803, 29, 102, 4.4, 1168, 44, 100);
        inserirAlimento(db, "Iogurte Natural", "Leite e derivados", 63, 4.7, 3.5, 3.3, 0, 88.3, 265, 3.3, 10, 0.9, 120, 15, 100);
        inserirAlimento(db, "Iogurte Desnatado", "Leite e derivados", 44, 6.5, 3.8, 0.2, 0, 89.5, 185, 0.2, 1, 0.6, 125, 17, 100);
        inserirAlimento(db, "Requeijão", "Leite e derivados", 257, 4.2, 10, 23, 0, 59.0, 1074, 23, 75, 1.9, 354, 10, 100);
        inserirAlimento(db, "Creme de Leite", "Leite e derivados", 195, 3.1, 2.2, 20, 0, 72.0, 816, 20, 62, 1.6, 65, 6, 100);
    }

    private void inserirOvos(SQLiteDatabase db) {
        inserirAlimento(db, "Ovo de galinha", "Ovos e derivados", 155, 1.1, 13, 11, 0, 74.0, 637, 11, 372, 1.0, 56, 12, 100);
        inserirAlimento(db, "Ovo de codorna", "Ovos e derivados", 158, 1.2, 13, 11.2, 0, 73.0, 651, 11.2, 375, 1.2, 59, 14, 100);
        inserirAlimento(db, "Ovo cozido", "Ovos e derivados", 155, 1.1, 13, 11, 0, 74.0, 637, 11, 372, 1.0, 56, 12, 100);
        inserirAlimento(db, "Omelete", "Ovos e derivados", 154, 1.2, 10, 12, 0, 75.0, 640, 12, 360, 0.9, 53, 13, 100);
        inserirAlimento(db, "Clara de Ovo", "Ovos e derivados", 52, 0.7, 11, 0.2, 0, 87.5, 213, 0.2, 0, 0.4, 7, 1, 100);
        inserirAlimento(db, "Gema de Ovo", "Ovos e derivados", 322, 3.6, 16, 27, 0, 48.0, 1354, 27, 1085, 2.5, 210, 21, 100);
        inserirAlimento(db, "Ovo Frito", "Ovos e derivados", 196, 1.1, 13, 15, 0, 68.0, 820, 15, 500, 1.4, 75, 15, 100);
        inserirAlimento(db, "Ovo Pochê", "Ovos e derivados", 143, 1.2, 12, 10, 0, 75.0, 586, 10, 320, 1.0, 55, 10, 100);
        inserirAlimento(db, "Ovo Mexido", "Ovos e derivados", 162, 1.4, 11, 12, 0, 73.0, 677, 12, 410, 1.3, 58, 13, 100);
        inserirAlimento(db, "Frittata", "Ovos e derivados", 120, 2, 8, 9, 0, 78.0, 502, 9, 260, 0.8, 48, 8, 100);
    }

    private void inserirBebidas(SQLiteDatabase db) {
        inserirAlimento(db, "Café", "Bebidas (alcoólicas e não alcoólicas)", 1, 0, 0.1, 0, 0, 99.7, 4, 0, 0, 0.1, 2, 1, 100);
        inserirAlimento(db, "Chá Verde", "Bebidas (alcoólicas e não alcoólicas)", 2, 0, 0.2, 0, 0, 99.5, 9, 0, 0, 0.1, 3, 2, 100);
        inserirAlimento(db, "Suco de Laranja", "Bebidas (alcoólicas e não alcoólicas)", 45, 10, 0.7, 0.2, 0, 88.3, 189, 0.2, 0, 0.5, 40, 15, 100);
        inserirAlimento(db, "Suco de Uva", "Bebidas (alcoólicas e não alcoólicas)", 60, 14, 0.7, 0.2, 0, 85.6, 251, 0.2, 0, 0.5, 18, 15, 100);
        inserirAlimento(db, "Água de Coco", "Bebidas (alcoólicas e não alcoólicas)", 19, 4, 0.7, 0.1, 1.1, 94.6, 79, 0.1, 0, 0.3, 15, 12, 100);
        inserirAlimento(db, "Refrigerante", "Bebidas (alcoólicas e não alcoólicas)", 41, 10, 0, 0, 0, 89.0, 172, 0, 0, 0.2, 2, 8, 100);
        inserirAlimento(db, "Cerveja", "Bebidas (alcoólicas e não alcoólicas)", 43, 3.6, 0.5, 0, 0, 92.0, 180, 0, 0, 0.4, 1, 6, 100);
        inserirAlimento(db, "Vinho Tinto", "Bebidas (alcoólicas e não alcoólicas)", 83, 2.7, 0.6, 0, 0, 87.5, 348, 0, 0, 0.6, 3, 12, 100);
        inserirAlimento(db, "Chá Preto", "Bebidas (alcoólicas e não alcoólicas)", 1, 0, 0.1, 0, 0, 99.7, 4, 0, 0, 0.1, 2, 1, 100);
        inserirAlimento(db, "Água", "Bebidas (alcoólicas e não alcoólicas)", 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 100);
    }

    private void inserirMiscelaneas(SQLiteDatabase db) {
        inserirAlimento(db, "Mel", "Miscelâneas", 304, 82, 0.3, 0, 0.2, 17.1, 1268, 0, 0, 0.2, 6, 2, 100);
        inserirAlimento(db, "Molho de Tomate", "Miscelâneas", 82, 16, 1.5, 0.5, 1.5, 80, 343, 0.5, 0, 0.8, 21, 10, 100);
        inserirAlimento(db, "Ketchup", "Miscelâneas", 112, 26, 1.3, 0.1, 0.3, 70, 467, 0.1, 0, 0.7, 15, 8, 100);
        inserirAlimento(db, "Mostarda", "Miscelâneas", 66, 5.5, 3.3, 4, 1.2, 83, 276, 4, 0, 1.1, 35, 19, 100);
        inserirAlimento(db, "Maionese", "Miscelâneas", 680, 0.6, 0.4, 75, 0, 24, 2833, 75, 0, 1.2, 18, 5, 100);
        inserirAlimento(db, "Pasta de Amendoim", "Miscelâneas", 588, 20, 25, 50, 6, 1.7, 2459, 50, 0, 2.3, 45, 33, 100);
        inserirAlimento(db, "Geleia", "Miscelâneas", 250, 65, 0.3, 0, 0.5, 34, 1050, 0, 0, 0.5, 8, 2, 100);
        inserirAlimento(db, "Caldo de Galinha", "Miscelâneas", 17, 2.5, 1.2, 0.5, 0, 93, 71, 0.5, 0, 0.2, 4, 1, 100);
        inserirAlimento(db, "Pimenta em Pó", "Miscelâneas", 282, 50, 14, 15, 34, 9, 1181, 15, 0, 2.8, 148, 90, 100);
        inserirAlimento(db, "Vinagre", "Miscelâneas", 18, 0.4, 0, 0, 0, 94, 75, 0, 0, 0, 8, 3, 100);
    }

    private void inserirNozes(SQLiteDatabase db) {
        inserirAlimento(db, "Amêndoas", "Nozes e sementes", 579, 22, 21, 50, 12.5, 4.0, 2411, 50, 0, 2.9, 269, 270, 100);
        inserirAlimento(db, "Castanha de Caju", "Nozes e sementes", 553, 30, 18, 44, 3.3, 5.2, 2309, 44, 0, 2.6, 37, 292, 100);
        inserirAlimento(db, "Castanha do Pará", "Nozes e sementes", 656, 12, 14, 66, 7.5, 3.4, 2747, 66, 0, 3.3, 160, 376, 100);
        inserirAlimento(db, "Noz", "Nozes e sementes", 654, 14, 15, 65, 6.7, 4.1, 2738, 65, 0, 2.6, 98, 158, 100);
        inserirAlimento(db, "Pistache", "Nozes e sementes", 562, 28, 20, 45, 10.3, 2.2, 2349, 45, 0, 3, 105, 121, 100);
        inserirAlimento(db, "Semente de Abóbora", "Nozes e sementes", 559, 15, 30, 46, 6, 5, 2336, 46, 0, 4.8, 55, 550, 100);
        inserirAlimento(db, "Semente de Girassol", "Nozes e sementes", 584, 20, 21, 51, 8.6, 4.7, 2445, 51, 0, 3.2, 78, 367, 100);
        inserirAlimento(db, "Macadâmia", "Nozes e sementes", 718, 14, 8, 76, 9, 2.3, 3006, 76, 0, 1.3, 85, 130, 100);
        inserirAlimento(db, "Avelã", "Nozes e sementes", 628, 17, 15, 61, 10, 4.7, 2628, 61, 0, 2.4, 114, 163, 100);
        inserirAlimento(db, "Noz Pecan", "Nozes e sementes", 691, 14, 9, 72, 9.6, 3.5, 2889, 72, 0, 1.5, 70, 121, 100);
    }

    private void inserirProdutosAcucarados(SQLiteDatabase db) {
        inserirAlimento(db, "Chocolate", "Produtos açucarados", 546, 61, 4.9, 31, 3.5, 1.0, 2283, 31, 12, 1.0, 56, 50, 100);
        inserirAlimento(db, "Bala de Goma", "Produtos açucarados", 348, 83, 0, 0.2, 0, 16.8, 1457, 0.2, 0, 0.1, 2, 3, 100);
        inserirAlimento(db, "Gelatina", "Produtos açucarados", 381, 94, 1.3, 0, 0, 5, 1596, 0, 0, 0.1, 1, 1, 100);
        inserirAlimento(db, "Biscoito Recheado", "Produtos açucarados", 493, 69, 4.5, 22, 3.5, 3, 2065, 22, 10, 1.2, 40, 55, 100);
        inserirAlimento(db, "Pé de Moleque", "Produtos açucarados", 521, 54, 14, 30, 5.5, 1.5, 2179, 30, 0, 2, 40, 48, 100);
        inserirAlimento(db, "Brigadeiro", "Produtos açucarados", 403, 66, 4, 12, 0.7, 2.8, 1685, 12, 15, 0.9, 50, 30, 100);
        inserirAlimento(db, "Paçoca", "Produtos açucarados", 504, 56, 11, 29, 5, 2, 2110, 29, 0, 1.7, 50, 40, 100);
        inserirAlimento(db, "Bolo de Cenoura", "Produtos açucarados", 310, 45, 5, 12, 1.2, 28, 1297, 12, 35, 0.8, 70, 55, 100);
        inserirAlimento(db, "Biscoito de Maizena", "Produtos açucarados", 480, 78, 6, 18, 1.1, 2.8, 2009, 18, 12, 0.5, 30, 45, 100);
        inserirAlimento(db, "Marshmallow", "Produtos açucarados", 318, 81, 2, 0, 0, 16, 1331, 0, 0, 0.2, 1, 5, 100);
    }


    private void inserirAlimento(SQLiteDatabase db, String nome, String categoria, double calorias, double carboidratos, double proteinas, double gorduras, double fibras, double umidade, double energia, double lipideos, double colesterol, double cinzas, double calcio, double magnesio, int quantidade) {
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("categoria", categoria);
        values.put("calorias", calorias);
        values.put("carboidratos", carboidratos);
        values.put("proteinas", proteinas);
        values.put("gorduras", gorduras);
        values.put("fibras", fibras);
        values.put("umidade", umidade);
        values.put("energia", energia);
        values.put("lipideos", lipideos);
        values.put("colesterol", colesterol);
        values.put("cinzas", cinzas);
        values.put("calcio", calcio);
        values.put("magnesio", magnesio);
        values.put("quantidadeporgramas", quantidade);
        db.insert("Alimento", null, values);
    }
}
