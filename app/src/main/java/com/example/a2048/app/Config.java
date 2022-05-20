package com.example.a2048.app;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a2048.db.ScoreDataBase;

public class Config {

    private ScoreDataBase scoreDataBase;
    public Config(Context context){
        scoreDataBase = new ScoreDataBase(context);
    }

    public int getScore(String id, String score_name){
        SQLiteDatabase db = scoreDataBase.getReadableDatabase();
        Cursor cursor = db.query("Score", null, "user_name=?",
                new String[]{id},
                null, null,null);
        if(!cursor.moveToFirst())
            return -1;
        @SuppressLint("Range") int ret = cursor.getInt(cursor.getColumnIndex(score_name));
        return ret;
    }


    public void setScore(String id, String name, int score){
        SQLiteDatabase db = scoreDataBase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(name, String.valueOf(score));
        db.update("Score", values, "user_name=?", new String[]{id});
    }

    public void insertScore(String id, String name1, String name2, int score1, int score2){
        SQLiteDatabase db = scoreDataBase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_name", id);
        values.put(name1, String.valueOf(score1));
        values.put(name2, String.valueOf(score2));
        db.insert("Score", null, values);
    }

}
