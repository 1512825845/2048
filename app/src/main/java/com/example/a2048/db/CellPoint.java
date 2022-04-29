package com.example.a2048.db;

import androidx.annotation.NonNull;

public class CellPoint {
    private final int x;
    private final int y;
    private final int num;

    public CellPoint(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getNum(){
        return num;
    }

    @NonNull
    @Override
    public String toString(){
        return "(" + x + "," + y + ")" + num + "\n";
    }
}
