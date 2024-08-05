package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int ADD_STUDENT_REQUEST = 1;
    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando a RecyclerView e o adaptador
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentList = new ArrayList<>();
        adapter = new StudentAdapter(studentList);
        recyclerView.setAdapter(adapter);

        // Botão flutuante para adicionar um novo estudante
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEditStudentActivity.class);
                startActivityForResult(intent, ADD_STUDENT_REQUEST);
            }
        });

        loadStudents();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_STUDENT_REQUEST && resultCode == RESULT_OK) {
            Student newStudent = (Student) data.getSerializableExtra("student");
            studentList.add(newStudent);
            adapter.notifyItemInserted(studentList.size() - 1);
            Toast.makeText(this, "Estudante adicionado", Toast.LENGTH_SHORT).show();
        }
    }

    // Carregar estudantes da base de dados
    private void loadStudents() {
        StudentDatabaseHelper dbHelper = new StudentDatabaseHelper(this);
        studentList.addAll(dbHelper.getAllStudents());
        adapter.notifyDataSetChanged();
    }
}