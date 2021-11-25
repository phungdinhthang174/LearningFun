package com.example.learningfun.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.learningfun.DbHelper.DbHelper;
import com.example.learningfun.Model.LogIn;

public class DAO_Login {
    DbHelper dbHelper ;

    public DAO_Login(Context context) {
        dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }
    public void ThemTK (LogIn lg) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", lg.getUsername());
        values.put("password", lg.getPassword());
        db.insert("Login", null, values);
    }
    public boolean testLogIn(String user,String pass){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String testt = "select * from Login where username ='"+user+"' and password = '"+pass+"'" ;
        Cursor cursor = db.rawQuery(testt,null);
        if (cursor.getCount() != 0){
            return true;
        } else {
            return false;
        }
    }
}
