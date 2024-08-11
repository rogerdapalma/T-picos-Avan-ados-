package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private Context context;
    private List<Student> studentList;
    private List<Student> selectedStudents = new ArrayList<>();

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.textViewName.setText(student.getName());
        holder.textViewCpf.setText(student.getCpf());
        holder.textViewPhone.setText(student.getPhone());
        holder.textViewAge.setText(String.valueOf(student.getAge()));

        holder.itemView.setOnClickListener(v -> {
            if (selectedStudents.contains(student)) {
                selectedStudents.remove(student);
                holder.itemView.setBackgroundColor(Color.WHITE);
            } else {
                selectedStudents.add(student);
                holder.itemView.setBackgroundColor(Color.LTGRAY);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }

    public void clearSelection() {
        selectedStudents.clear();
        notifyDataSetChanged();
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewCpf, textViewPhone, textViewAge;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewCpf = itemView.findViewById(R.id.text_view_cpf);
            textViewPhone = itemView.findViewById(R.id.text_view_phone);
            textViewAge = itemView.findViewById(R.id.text_view_age);
        }
    }
}