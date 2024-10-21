package com.example.nutricomp.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nutricomp.R;
import com.example.nutricomp.UserManager;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextSenha;
    private Button buttonLogin, buttonGoToRegister;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ativar botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        userManager = new UserManager(this);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonGoToRegister = findViewById(R.id.buttonGoToRegister);

        buttonLogin.setOnClickListener(v -> loginUsuario());
        buttonGoToRegister.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }

    private void loginUsuario() {
        String email = editTextEmail.getText().toString().trim();
        String senha = editTextSenha.getText().toString().trim();

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor cursor = userManager.obterUsuario(email, senha);
        if (cursor.moveToFirst()) {
            Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
            // Redirecionar para outra Activity
            startActivity(new Intent(this, MainActivity.class));
        } else {
            Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
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
