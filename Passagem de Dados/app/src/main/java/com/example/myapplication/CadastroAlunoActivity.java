package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroAlunoActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextIdade;
    private Button buttonEnviarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        // Inicializar os componentes
        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        buttonEnviarDados = findViewById(R.id.buttonEnviarDados);

        // Definir o clique no botão
        buttonEnviarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Capturar os dados
                String nome = editTextNome.getText().toString();
                String idade = editTextIdade.getText().toString();

                // Criar uma Intent para navegar para a DetalhesAlunoActivity
                Intent intent = new Intent(CadastroAlunoActivity.this, DetalhesAlunoActivity.class);
                intent.putExtra("nomeAluno", nome);
                intent.putExtra("idadeAluno", idade);

                // Iniciar a nova Activity
                startActivity(intent);
            }
        });
    }
}
