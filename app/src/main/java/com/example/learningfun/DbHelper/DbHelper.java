package com.example.learningfun.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "Quizzi.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Table_Login= "create table if not exists Login(username text primary key, password text)";
        sqLiteDatabase.execSQL(Table_Login);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //i = old version, i1 = newVersion
        String sql = "drop table if exists Login";
        sqLiteDatabase.execSQL(sql);

    }
}
