package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddEditStudentActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final String TAG = "AddEditStudentActivity";

    private EditText editTextName, editTextCpf, editTextPhone, editTextAge;
    private ImageView imageViewStudentPhoto;
    private Button buttonSave, buttonTakePhoto;
    private StudentDatabaseHelper databaseHelper;
    private int studentId = -1;  // -1 indica que estamos adicionando um novo estudante
    private Bitmap studentPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Iniciado");
        setContentView(R.layout.activity_add_edit_student);

        try {
            editTextName = findViewById(R.id.edit_text_name);
            editTextCpf = findViewById(R.id.edit_text_cpf);
            editTextPhone = findViewById(R.id.edit_text_phone);
            editTextAge = findViewById(R.id.edit_text_age);
            imageViewStudentPhoto = findViewById(R.id.image_view_student_photo);
            buttonSave = findViewById(R.id.button_save);
            buttonTakePhoto = findViewById(R.id.button_take_photo);
            databaseHelper = new StudentDatabaseHelper(this);

            Log.d(TAG, "onCreate: Views iniciais encontradas");

            // Verificar se estamos editando um estudante existente
            if (getIntent().hasExtra("student_id")) {
                studentId = getIntent().getIntExtra("student_id", -1);
                loadStudentData(studentId);
            }

            // Configuração do botão de tirar foto
            buttonTakePhoto.setOnClickListener(v -> {
                Log.d(TAG, "Botão tirar foto clicado");
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                } else {
                    Toast.makeText(this, "Não é possível acessar a câmera", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Câmera não acessível");
                }
            });

            // Configuração do botão de salvar
            buttonSave.setOnClickListener(view -> {
                Log.d(TAG, "Botão salvar clicado");
                if (validateInput()) {
                    String name = editTextName.getText().toString().trim();
                    String cpf = editTextCpf.getText().toString().trim();
                    String phone = editTextPhone.getText().toString().trim();
                    String age = editTextAge.getText().toString().trim();

                    if (studentPhoto == null) {
                        Toast.makeText(AddEditStudentActivity.this, "Por favor, tire uma foto do estudante", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "Foto do estudante não encontrada");
                        return;
                    }

                    String photoBase64 = Utils.bitmapToBase64(studentPhoto);

                    if (studentId == -1) {
                        // Adicionar novo estudante
                        Student student = new Student(name, cpf, phone, age, photoBase64);
                        databaseHelper.addStudent(student);
                        Toast.makeText(AddEditStudentActivity.this, "Estudante adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                    } else {
                        // Atualizar estudante existente
                        Student student = new Student(studentId, name, cpf, phone, age, photoBase64);
                        databaseHelper.updateStudent(student);
                        Toast.makeText(AddEditStudentActivity.this, "Estudante atualizado com sucesso!", Toast.LENGTH_SHORT).show();
                    }

                    setResult(RESULT_OK);
                    finish();
                }
            });

            Log.d(TAG, "onCreate: Configurações finais feitas");

        } catch (Exception e) {
            Log.e(TAG, "Erro no onCreate: ", e);
            Toast.makeText(this, "Erro ao iniciar a atividade: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: Iniciado com requestCode=" + requestCode + " e resultCode=" + resultCode);
        try {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                studentPhoto = (Bitmap) extras.get("data");
                imageViewStudentPhoto.setImageBitmap(studentPhoto);
                Log.d(TAG, "Foto capturada com sucesso");
            }
        } catch (Exception e) {
            Log.e(TAG, "Erro ao processar a imagem: ", e);
        }
    }

    private void loadStudentData(int studentId) {
        Log.d(TAG, "loadStudentData: Carregando dados do estudante com ID=" + studentId);
        try {
            Student student = databaseHelper.getStudentById(studentId);
            if (student != null) {
                editTextName.setText(student.getName());
                editTextCpf.setText(student.getCpf());
                editTextPhone.setText(student.getPhone());
                editTextAge.setText(student.getAge());

                // Carregar a foto do estudante
                if (student.getPhoto() != null) {
                    studentPhoto = Utils.base64ToBitmap(student.getPhoto());
                    imageViewStudentPhoto.setImageBitmap(studentPhoto);
                }
            } else {
                Log.e(TAG, "Estudante não encontrado no banco de dados");
            }
        } catch (Exception e) {
            Log.e(TAG, "Erro ao carregar dados do estudante: ", e);
        }
    }

    private boolean validateInput() {
        Log.d(TAG, "validateInput: Iniciando validação dos campos");
        if (editTextName.getText().toString().trim().isEmpty()) {
            showToast("Por favor, insira o nome");
            return false;
        }
        if (editTextCpf.getText().toString().trim().isEmpty() || editTextCpf.getText().toString().trim().length() != 14) {
            showToast("Por favor, insira um CPF válido no formato 000.000.000-00");
            return false;
        }
        if (editTextPhone.getText().toString().trim().isEmpty() || editTextPhone.getText().toString().trim().length() != 15) {
            showToast("Por favor, insira um telefone válido no formato (000) 00000-0000");
            return false;
        }
        if (editTextAge.getText().toString().trim().isEmpty()) {
            showToast("Por favor, insira a idade");
            return false;
        }
        try {
            int age = Integer.parseInt(editTextAge.getText().toString().trim());
            if (age <= 0) {
                showToast("Por favor, insira uma idade válida");
                return false;
            }
        } catch (NumberFormatException e) {
            showToast("Por favor, insira uma idade válida");
            Log.e(TAG, "Erro de validação de idade: ", e);
            return false;
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
