package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesAlunoActivity extends AppCompatActivity {

    private TextView textViewNome;
    private TextView textViewIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_aluno);

        // Inicializar os componentes
        textViewNome = findViewById(R.id.textViewNome);
        textViewIdade = findViewById(R.id.textViewIdade);

        // Receber os dados da Intent
        String nome = getIntent().getStringExtra("nomeAluno");
        String idade = getIntent().getStringExtra("idadeAluno");

        // Exibir os dados nos TextViews
        textViewNome.setText("Nome: " + nome);
        textViewIdade.setText("Idade: " + idade);
    }
}
