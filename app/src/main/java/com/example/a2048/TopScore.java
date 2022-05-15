package com.example.a2048;

import android.content.Context;
import android.content.SharedPreferences;

public class TopScore {
    private SharedPreferences s;
    TopScore(Context context){
        s = context.getSharedPreferences("topscore",context.MODE_PRIVATE);
    }

    public int getTopScore(){
        int topscore = s.getInt("topscore",0);
        return topscore;
    }

    public void setTopScore(int topScore){
        SharedPreferences.Editor editor = s.edit();
        editor.putInt("topscore",topScore);
        editor.commit();
    }
}
