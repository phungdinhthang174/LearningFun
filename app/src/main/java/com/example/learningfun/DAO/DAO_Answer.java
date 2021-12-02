package com.example.learningfun.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.learningfun.DbHelper.DbHelper;
import com.example.learningfun.Model.Answer;

public class DAO_Answer {
    DbHelper dbHelper;


    public DAO_Answer(Context context) {
        dbHelper = new DbHelper(context);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();


    }
    public void insertAnswer(Answer answer){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contentA",answer.getContent());
        contentValues.put("isCorrect",answer.isCorrect());

        sqLiteDatabase.insert("Answer",null,contentValues);

    }
}
