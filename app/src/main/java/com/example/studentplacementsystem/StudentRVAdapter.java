package com.example.studentplacementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentRVAdapter extends RecyclerView.Adapter<StudentRVAdapter.ViewHolder> {
    private ArrayList<StudentModal> StudentModalArrayList;
    private Context context;

    // constructor
    public StudentRVAdapter(ArrayList<StudentModal> StudentModalArrayList, Context context) {
        this.StudentModalArrayList = StudentModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentModal modal = StudentModalArrayList.get(position);
        holder.studentNameTV.setText(modal.getStudentName());
        holder.studentBranchTV.setText(modal.getStudentBranch());
        holder.studentIdTV.setText(modal.getStudentId());
        holder.studentPercentageTV.setText(modal.getStudentPercentage());
    }

    @Override
    public int getItemCount() {
        return StudentModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView studentNameTV, studentBranchTV, studentIdTV, studentPercentageTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentNameTV = itemView.findViewById(R.id.idTVStudentName);
            studentBranchTV = itemView.findViewById(R.id.idTVStudentBranch);
            studentIdTV = itemView.findViewById(R.id.idTVStudentId);
            studentPercentageTV = itemView.findViewById(R.id.idTVStudentPercentage);
        }
    }
}
