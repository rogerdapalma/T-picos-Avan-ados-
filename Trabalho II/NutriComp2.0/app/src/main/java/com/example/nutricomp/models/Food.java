package com.example.nutricomp.models;

public class Food {
    private String nome;
    private String categoria;
    private float calorias;
    private float carboidratos;
    private float proteinas;
    private float gorduras;
    private float fibras;
    private float umidade;
    private float energia;
    private float lipideos;
    private float colesterol;
    private float cinzas;
    private float calcio;
    private float magnesio;

    public Food(String nome, String categoria, float calorias, float carboidratos, float proteinas,
                float gorduras, float fibras, float umidade, float energia, float lipideos,
                float colesterol, float cinzas, float calcio, float magnesio) {
        this.nome = nome;
        this.categoria = categoria;
        this.calorias = calorias;
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.gorduras = gorduras;
        this.fibras = fibras;
        this.umidade = umidade;
        this.energia = energia;
        this.lipideos = lipideos;
        this.colesterol = colesterol;
        this.cinzas = cinzas;
        this.calcio = calcio;
        this.magnesio = magnesio;
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

    public float getUmidade() {
        return umidade;
    }

    public float getEnergia() {
        return energia;
    }

    public float getLipideos() {
        return lipideos;
    }

    public float getColesterol() {
        return colesterol;
    }

    public float getCinzas() {
        return cinzas;
    }

    public float getCalcio() {
        return calcio;
    }

    public float getMagnesio() {
        return magnesio;
    }
}
