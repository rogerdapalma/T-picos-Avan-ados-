package com.example.myapplication;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String cpf = editTextCpf.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                int age = Integer.parseInt(editTextAge.getText().toString().trim());

                Student student = new Student(0, name, cpf, phone, age);
                databaseHelper.addStudent(student);
                finish();
            }
        });
    }
}
