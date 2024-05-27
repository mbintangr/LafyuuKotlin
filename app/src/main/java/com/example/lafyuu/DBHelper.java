package com.example.lafyuu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBName = "dataUser.db";

    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(email TEXT, password TEXT, fullName TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);
    }

    public void insertUserData(String email, String password, String fullName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("fullName", fullName);
        db.insert("user", null, contentValues);
    }

    public boolean loginAccount(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("select * from user where email = ? and password = ?", new String[]{email, password});
        if (cur.getCount() > 0) {
            return true;
        } else return false;
    }

    public Cursor getAllAlumni() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT nim, nama FROM alumni", null);
    }

}
