package com.example.nutricomp.models;

public class Food {
    private String nome;
    private String categoria;
    private float calorias;
    private float carboidratos;
    private float proteinas;
    private float gorduras;
    private float fibras;

    public Food(String nome, String categoria, float calorias, float carboidratos, float proteinas, float gorduras, float fibras) {
        this.nome = nome;
        this.categoria = categoria;
        this.calorias = calorias;
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.gorduras = gorduras;
        this.fibras = fibras;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public float getCalorias() {
        return calorias;
    }

    public float getCarboidratos() {
        return carboidratos;
    }

    public float getProteinas() {
        return proteinas;
    }

    public float getGorduras() {
        return gorduras;
    }

    public float getFibras() {
        return fibras;
    }
}
