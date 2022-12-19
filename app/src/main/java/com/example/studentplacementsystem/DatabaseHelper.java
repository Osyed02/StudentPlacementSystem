package com.example.studentplacementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "StudentPlacementSystem";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE Users(ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)";
        db.execSQL(createUserTable);

        String createStudentTable = "CREATE TABLE Students(ID INTEGER PRIMARY KEY AUTOINCREMENT, StudentName TEXT, StudentPassword TEXT, StudentId INTEGER, StudentBranch TEXT, StudentPercentage TEXT)";
        db.execSQL(createStudentTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "Users");
        db.execSQL("DROP TABLE IF EXISTS " + "Students");
        onCreate(db);
    }

    public boolean Insert(String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = sqLiteDatabase.insert("Users", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public void addNewStudent(String StudentName,String StudentPassword, String StudentId, String StudentBranch, String StudentPercentage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("StudentName", StudentName);
        values.put("StudentPassword", StudentPassword);
        values.put("StudentId", StudentId);
        values.put("StudentBranch", StudentBranch);
        values.put("StudentPercentage", StudentPercentage);

        db.insert("Students", null, values);
        db.close();
    }

    public Boolean CheckUsername(String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=?", new String[]{username});

        if(cursor.getCount() > 0){
            return false;
        }else{
            return true;
        }
    }

    public Boolean CheckLogin(String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=? AND password=?", new String[]{username, password});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<StudentModal> readStudents() {
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorStudents = db.rawQuery("SELECT * FROM " + "Students", null);

        // on below line we are creating a new array list.
        ArrayList<StudentModal> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorStudents.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new StudentModal(cursorStudents.getString(1),
                        cursorStudents.getString(4),
                        cursorStudents.getString(2),
                        cursorStudents.getString(3),
                        cursorStudents.getString(4)));

            } while (cursorStudents.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorStudents.close();
        return courseModalArrayList;
    }
}
