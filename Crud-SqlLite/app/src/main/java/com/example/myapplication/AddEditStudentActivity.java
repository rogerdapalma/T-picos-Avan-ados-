package com.example.myapplication;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddEditStudentActivity extends AppCompatActivity {
    private EditText editTextName, editTextCpf, editTextPhone, editTextAge;
    private Button buttonSave;
    private StudentDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_student);

        editTextName = findViewById(R.id.edit_text_name);
        editTextCpf = findViewById(R.id.edit_text_cpf);
        editTextPhone = findViewById(R.id.edit_text_phone);
        editTextAge = findViewById(R.id.edit_text_age);
        buttonSave = findViewById(R.id.button_save);
        databaseHelper = new StudentDatabaseHelper(this);

        // TextWatcher para CPF
        editTextCpf.addTextChangedListener(new TextWatcher() {
            private String current = "";
            private String cpfMask = "###.###.###-##";
            private final char placeholder = '#';

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String cleanString = s.toString().replaceAll("[^\\d]", "");
                    StringBuilder maskedString = new StringBuilder();
                    int index = 0;

                    for (char c : cpfMask.toCharArray()) {
                        if (c == placeholder) {
                            if (index < cleanString.length()) {
                                maskedString.append(cleanString.charAt(index));
                                index++;
                            } else {
                                break;
                            }
                        } else {
                            maskedString.append(c);
                        }
                    }

                    current = maskedString.toString();
                    editTextCpf.setText(current);
                    editTextCpf.setSelection(current.length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // TextWatcher para Telefone
        editTextPhone.addTextChangedListener(new TextWatcher() {
            private String current = "";
            private String phoneMask = "(###) #####-###";
            private final char placeholder = '#';

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String cleanString = s.toString().replaceAll("[^\\d]", "");
                    StringBuilder maskedString = new StringBuilder();
                    int index = 0;

                    for (char c : phoneMask.toCharArray()) {
                        if (c == placeholder) {
                            if (index < cleanString.length()) {
                                maskedString.append(cleanString.charAt(index));
                                index++;
                            } else {
                                break;
                            }
                        } else {
                            maskedString.append(c);
                        }
                    }

                    current = maskedString.toString();
                    editTextPhone.setText(current);
                    editTextPhone.setSelection(current.length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput()) {
                    String name = editTextName.getText().toString().trim();
                    String cpf = editTextCpf.getText().toString().trim();
                    String phone = editTextPhone.getText().toString().trim();
                    int age = Integer.parseInt(editTextAge.getText().toString().trim());

                    Student student = new Student(0, name, cpf, phone, age);
                    databaseHelper.addStudent(student);
                    finish();
                }
            }
        });
    }

    private boolean validateInput() {
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
            return false;
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
