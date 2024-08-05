package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.nameTextView.setText(student.getName());
        holder.cpfTextView.setText(student.getCpf());
        holder.phoneTextView.setText(student.getPhone());
        holder.ageTextView.setText(String.valueOf(student.getAge()));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, cpfTextView, phoneTextView, ageTextView;

        StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.text_view_name);
            cpfTextView = itemView.findViewById(R.id.text_view_cpf);
            phoneTextView = itemView.findViewById(R.id.text_view_phone);
            ageTextView = itemView.findViewById(R.id.text_view_age);
        }
    }
}
