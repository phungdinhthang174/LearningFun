package com.example.learningfun.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.learningfun.DbHelper.DbHelper;
import com.example.learningfun.Model.LogIn;
import com.example.learningfun.Model.TT;

import java.util.ArrayList;
import java.util.List;

public class DAO_TT {
    DbHelper dbHelper;

    public DAO_TT(Context context) {
        dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }
    public void ThemTT (TT tt) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hoten", tt.getHoten());
        values.put("email", tt.getEmail());
        values.put("ngsinh",tt.getNgaySinh());
        values.put("sdt",tt.getSdt());
        db.insert("TT", null, values);
    }
    public void UpdateTT(TT tt){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hoten", tt.getHoten());
        values.put("email", tt.getEmail());
        values.put("ngsinh",tt.getNgaySinh());
        values.put("sdt",tt.getSdt());
        db.update("TT",values,"hoten"+ tt.getHoten(),null);
    }
    public List<TT> getTT(){
        ArrayList<TT> ttArrayList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from TT",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String hoten = cursor.getString(0);
            String email = cursor.getString(1);
            String ngsinh = cursor.getString(2);
            String sdt = cursor.getString(3);

            ttArrayList.add(new TT(hoten,email,ngsinh,sdt));
            cursor.moveToNext();

        }
        cursor.close();
        return ttArrayList;
    }
}
