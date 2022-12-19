package com.example.studentplacementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button goto_student, goto_tpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goto_student = (Button)findViewById(R.id.goto_student);
        goto_tpo = (Button)findViewById(R.id.goto_tpo);

        goto_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateStudentActivity.class);
                startActivity(intent);
            }
        });
        goto_tpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateTPOActivity.class);
                startActivity(intent);
            }
        });
    }
}