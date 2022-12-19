package com.example.studentplacementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewStudentsActivity extends AppCompatActivity {
    private ArrayList<StudentModal> courseModalArrayList;
    private DatabaseHelper databaseHelper;
    private StudentRVAdapter courseRVAdapter;
    private RecyclerView studentRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

        // initializing our all variables.
        courseModalArrayList = new ArrayList<>();
        databaseHelper = new DatabaseHelper(ViewStudentsActivity.this);

        // getting our course array
        // list from db handler class.
        courseModalArrayList = databaseHelper.readStudents();

        // on below line passing our array lost to our adapter class.
        courseRVAdapter = new StudentRVAdapter(courseModalArrayList, ViewStudentsActivity.this);
        studentRV = findViewById(R.id.idRVStudents);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewStudentsActivity.this, RecyclerView.VERTICAL, false);
        studentRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        studentRV.setAdapter(courseRVAdapter);
    }
}