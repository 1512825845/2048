package com.example.a2048.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ScoreDataBase extends SQLiteOpenHelper {

    private static final String db_name = "Score";

    private static final String START = "create table Score ("
            + "user_name, "
            + "best integer, "
            + "current integer)";

    public ScoreDataBase(Context context){
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(START);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
