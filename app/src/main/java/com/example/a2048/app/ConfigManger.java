package com.example.a2048.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class ConfigManger extends Application {
    public static int getCurrentScore(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "SAVE_CURRENT_SCORES", 0
        );
        return sharedPreferences.getInt("CURRENT_SCORES", 0);
    }

    public static void setCurrentScore(Context context, int score){
        SharedPreferences.Editor editor = context.getSharedPreferences("SAVE_CURRENT_SCORES",
         0).edit();
        editor.putInt("CURRENT_SCORES", score).apply();
    }

    public static int getBestScore(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "SAVE_BEST_SCORES", 0
        );
        return sharedPreferences.getInt("GET_BEST_SCORES", 0);
    }

    public static void setBestScore(int score) {
    }
}
