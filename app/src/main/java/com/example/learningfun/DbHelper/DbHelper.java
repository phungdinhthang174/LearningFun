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

        //thong tin
        String Table_TT = "create table if not exists TT(hoten text primary key,email text,ngsinh text,sdt text)";
        sqLiteDatabase.execSQL(Table_TT);
        //cau hoi
       String Table_Question = "create table if not exists Question(number integer primary key , content text,option1 text,option2 text, option3 text , option4 text,answer text )";
       sqLiteDatabase.execSQL(Table_Question);
       String insert_Question = "insert into Question values (1,'ABCD','A','b','c','d','A')";
       sqLiteDatabase.execSQL(insert_Question);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //i = old version, i1 = newVersion
        String sql = "drop table if exists Login";
        sqLiteDatabase.execSQL(sql);
        String sql1 = "drop table if exists TT";
        sqLiteDatabase.execSQL(sql1);

    }
}
