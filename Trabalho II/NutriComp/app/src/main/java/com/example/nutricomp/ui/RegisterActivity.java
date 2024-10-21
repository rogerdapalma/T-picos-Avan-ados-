package com.example.nutricomp.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nutricomp.R;
import com.example.nutricomp.UserManager;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextNome, editTextEmail, editTextSenha;
    private Button buttonRegistrar;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Ativar botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        userManager = new UserManager(this);
        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);

        buttonRegistrar.setOnClickListener(v -> {
            String nome = editTextNome.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String senha = editTextSenha.getText().toString().trim();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean sucesso = userManager.inserirUsuario(nome, email, senha);
            if (sucesso) {
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Erro ao cadastrar usuário", Toast.LENGTH_SHORT).show();
            }
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
}
