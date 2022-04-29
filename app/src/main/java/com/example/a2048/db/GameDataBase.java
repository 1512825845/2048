package com.example.a2048.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GameDataBase extends SQLiteOpenHelper {

    private static final String START = "create table G4 ("
            + "id integer primary key autoincrement, "
            + "x integer, "
            + "y integer, "
            + "num integer)";

    public GameDataBase(@Nullable Context context, @Nullable String name,
                        @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(START);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
