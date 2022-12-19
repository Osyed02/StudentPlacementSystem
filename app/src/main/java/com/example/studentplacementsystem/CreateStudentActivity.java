package com.example.studentplacementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateStudentActivity extends AppCompatActivity {

    private EditText StudentNameEdt,StudentPasswordEdt, StudentIdEdt, StudentBranchEdt, StudentPercentageEdt;
    private Button addStudentBtn,readStudentsBtn;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);

        StudentNameEdt = findViewById(R.id.idEdtStudentName);
        StudentPasswordEdt = findViewById(R.id.idEdtStudentPassword);
        StudentIdEdt = findViewById(R.id.idEdtStudentId);
        StudentBranchEdt = findViewById(R.id.idEdtStudentBranch);
        StudentPercentageEdt = findViewById(R.id.idEdtStudentPercentage);
        addStudentBtn = findViewById(R.id.idBtnAddStudent);
        readStudentsBtn = findViewById(R.id.idBtnReadStudents);

        databaseHelper = new DatabaseHelper(CreateStudentActivity.this);

        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String studentName = StudentNameEdt.getText().toString();
                String studentPassword = StudentPasswordEdt.getText().toString();
                String studentId = StudentIdEdt.getText().toString();
                String studentBranch = StudentBranchEdt.getText().toString();
                String studentPercentage = StudentPercentageEdt.getText().toString();

                if (studentName.isEmpty() && studentPassword.isEmpty() && studentId.isEmpty() && studentBranch.isEmpty() && studentPercentage.isEmpty()) {
                    Toast.makeText(CreateStudentActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                databaseHelper.addNewStudent(studentName, studentPassword, studentId, studentBranch,studentPercentage);

                Toast.makeText(CreateStudentActivity.this, "Student has been added.", Toast.LENGTH_SHORT).show();
                StudentNameEdt.setText("");
                StudentPasswordEdt.setText("");
                StudentIdEdt.setText("");
                StudentBranchEdt.setText("");
                StudentPercentageEdt.setText("");
            }
        });

        readStudentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(CreateStudentActivity.this, ViewStudentsActivity.class);
                startActivity(i);
            }
        });

    }
}