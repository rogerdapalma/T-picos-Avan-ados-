package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ADD_STUDENT = 1;  // Definindo a constante REQUEST_CODE_ADD_STUDENT
    private static final int REQUEST_CODE_EDIT_STUDENT = 2; // Definindo a constante REQUEST_CODE_EDIT_STUDENT

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;
    private FloatingActionButton fabAdd, fabDelete, fabEdit;
    private StudentDatabaseHelper studentDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentDatabaseHelper = new StudentDatabaseHelper(this);

        recyclerView = findViewById(R.id.recycler_view);
        fabAdd = findViewById(R.id.fab);
        fabDelete = findViewById(R.id.fab_delete);
        fabEdit = findViewById(R.id.fab_refresh);  // Mudando o botão de refresh para editar

        // Configurando o RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentList = loadStudentsFromDatabase();
        studentAdapter = new StudentAdapter(this, studentList);
        recyclerView.setAdapter(studentAdapter);

        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEditStudentActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_STUDENT);
        });

        fabDelete.setOnClickListener(v -> {
            List<Student> selectedStudents = studentAdapter.getSelectedStudents();
            if (selectedStudents.isEmpty()) {
                Toast.makeText(this, "Nenhum estudante selecionado", Toast.LENGTH_SHORT).show();
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Confirmação")
                        .setMessage("Deseja realmente deletar " + selectedStudents.size() + " estudantes?")
                        .setPositiveButton("Sim", (dialog, which) -> {
                            deleteSelectedStudents(selectedStudents);
                            refreshStudentList();  // Atualizar a lista após a exclusão
                        })
                        .setNegativeButton("Não", null)
                        .show();
            }
        });

        fabEdit.setOnClickListener(v -> {
            List<Student> selectedStudents = studentAdapter.getSelectedStudents();
            if (selectedStudents.size() != 1) {
                Toast.makeText(this, "Selecione exatamente um estudante para editar", Toast.LENGTH_SHORT).show();
            } else {
                Student studentToEdit = selectedStudents.get(0);
                Intent intent = new Intent(MainActivity.this, AddEditStudentActivity.class);
                intent.putExtra("student_id", studentToEdit.getId());
                startActivityForResult(intent, REQUEST_CODE_EDIT_STUDENT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            refreshStudentList();  // Atualizar a lista após adicionar ou editar um estudante
        }
    }

    private List<Student> loadStudentsFromDatabase() {
        // Carregar estudantes do banco de dados
        return studentDatabaseHelper.getAllStudents();
    }

    private void deleteSelectedStudents(List<Student> selectedStudents) {
        for (Student student : selectedStudents) {
            studentDatabaseHelper.deleteStudent(student.getId());
        }
        Toast.makeText(this, "Estudantes deletados com sucesso", Toast.LENGTH_SHORT).show();
    }

    private void refreshStudentList() {
        studentList = loadStudentsFromDatabase();  // Recarregar a lista do banco de dados
        studentAdapter.setStudentList(studentList);  // Atualizar a lista no adapter
        studentAdapter.notifyDataSetChanged();  // Notificar o adapter para atualizar a interface
    }
}
