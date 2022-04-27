package com.example.a2048.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.GridLayout;

import com.example.a2048.util.DensityUtil;

public class GameView extends GridLayout {

    private Cell[][] cells;
    public int mode;
    private int columnCnt;

    public GameView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        mode = 0;
        init();
    }
    public GameView(Context context){
        super(context);
        mode = 0;
        init();
    }
    public GameView(Context context, AttributeSet attrs){
        super(context, attrs);
        mode = 0;
        init();
    }
    private void init(){
        if(mode == 0)
            columnCnt = 4;
        removeAllViews();
        setColumnCount(columnCnt);
        cells = new Cell[columnCnt][columnCnt];
        int cellSize = getCellSize();
        addCell(cellSize);

    }

    private void addCell(int cellSize) {
        Cell cell;
        for(int i = 0;i < columnCnt; i++){
            for(int j = 0;j < columnCnt; j++){
                cell = new Cell(this.getContext());
                cell.setNum(0);
                addView(cell, cellSize, cellSize);
                cells[i][j] = cell;
            }
        }
    }

    private int getCellSize() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int ret = metrics.widthPixels - DensityUtil.dp2px(this.getContext());
        return (ret - 12) / columnCnt;
    }
}
