package com.example.a2048;

import android.content.Context;
import android.content.SharedPreferences;

public class TopScore {
    private SharedPreferences s;
    TopScore(Context context){
        s = context.getSharedPreferences("topscore",context.MODE_PRIVATE);
    }
    //获取最高分
    public int getTopScore(){
        int topscore = s.getInt("topscore",0);
        return topscore;
    }
    //设置最高分
    public void setTopScore(int topScore){
        SharedPreferences.Editor editor = s.edit();
        editor.putInt("topscore",topScore);
        editor.commit();
    }
}
