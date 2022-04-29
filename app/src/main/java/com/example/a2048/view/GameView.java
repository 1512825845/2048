package com.example.a2048.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.GridLayout;

import com.example.a2048.app.ConfigManger;
import com.example.a2048.db.CellPoint;
import com.example.a2048.util.DensityUtil;
import com.example.a2048.db.GameDataBase;

import java.util.ArrayList;
import java.util.List;

public class GameView extends GridLayout {

    private Cell[][] cells;
    public int mode;
    private int columnCnt;
    private final GameDataBase gameDataBase;
    private final List<CellPoint> emptyCellPoint = new ArrayList<>();
    private boolean swipe;
    private float prevX;
    private float prevY;
    private float offsetX;
    private float offsetY;
    private final List<Integer> currentNumList = new ArrayList<>();
    private final List<Integer> prevNumList = new ArrayList<>();
    private int prevNum = -1;
    private boolean win = false;

    public GameView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        mode = 0;
        setOrientation(GridLayout.HORIZONTAL);
        gameDataBase = new GameDataBase(context, "2048DB", null, 1);
        init();
    }
    public GameView(Context context){
        super(context);
        mode = 0;
        gameDataBase = new GameDataBase(context, "2048DB", null, 1);
        init();
    }
    public GameView(Context context, AttributeSet attrs){
        super(context, attrs);
        mode = 0;
        gameDataBase = new GameDataBase(context, "2048DB", null, 1);
        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void init(){
        swipe = true;
        if(mode == 0)
            columnCnt = 4;
        removeAllViews();
        setColumnCount(columnCnt);
        cells = new Cell[columnCnt][columnCnt];
        int cellSize = getCellSize();
        addCell(cellSize);
        startGame();
        setOnTouchListener((v, event)->{
            v.getParent().requestDisallowInterceptTouchEvent(true);
            if(swipe){
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        prevX = event.getX();
                        prevY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        offsetX = event.getX() - prevX;
                        offsetY = event.getY() - prevY;
                        int dir = getSwipeDir(offsetX, offsetY);
                        switch (dir){
                            case 1:
                                swipeLeft();
                                break;
                            case 2:
                                swipeRight();
                                break;
                            case 3:
                                swipeUp();
                                break;
                            case 4:
                                swipeDown();
                                break;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            }
            return true;
        });
    }

    private void swipeDown() {
        boolean merge = false;
        for(int i = 0; i < columnCnt; i++){
            for(int j = 0; j < columnCnt; j++) {
                int num = cells[j][i].getNum();
                prevNumList.add(num);
                if(num != 0){
                    if(prevNum == -1)
                        prevNum = num;
                    else {
                        if(prevNum != num) {
                            currentNumList.add(prevNum);
                            prevNum = num;
                        }
                        else {
                            currentNumList.add(num * 2);
                            recordScore(num * 2);
                            prevNum = -1;
                        }
                    }
                }
            }
            if(prevNum != -1){
                currentNumList.add(prevNum);
            }
            for(int j = currentNumList.size(); j < columnCnt; j++){
                currentNumList.add(0);
            }
            if(!currentNumList.equals(prevNumList)){
                merge = true;
            }
            prevNumList.clear();
            for(int j = 0; j < currentNumList.size(); j++){
                cells[j][i].setNum(currentNumList.get(j));
            }
            currentNumList.clear();
            prevNum = -1;
        }
        if(merge){
            setNum();
            check();
        }
    }

    private void swipeUp() {
        boolean merge = false;
        for(int i = 0; i < columnCnt; i++){
            for(int j = columnCnt - 1; j >= 0; j--) {
                int num = cells[j][i].getNum();
                prevNumList.add(num);
                if(num != 0){
                    if(prevNum == -1)
                        prevNum = num;
                    else {
                        if(prevNum != num) {
                            currentNumList.add(prevNum);
                            prevNum = num;
                        }
                        else {
                            currentNumList.add(num * 2);
                            recordScore(num * 2);
                            prevNum = -1;
                        }
                    }
                }
            }
            if(prevNum != -1){
                currentNumList.add(prevNum);
            }
            for(int j = currentNumList.size(); j < columnCnt; j++){
                currentNumList.add(0);
            }
            if(!currentNumList.equals(prevNumList)){
                merge = true;
            }
            prevNumList.clear();
            for(int j = columnCnt - 1; j >= 0; j--){
                cells[j][i].setNum(currentNumList.get(columnCnt - j - 1));
            }
            currentNumList.clear();
            prevNum = -1;
        }
        if(merge){
            setNum();
            check();
        }
    }

    private void swipeRight() {
        boolean merge = false;
        for(int i = 0; i < columnCnt; i++){
            for(int j = columnCnt - 1; j >= 0; j--) {
                int num = cells[i][j].getNum();
                prevNumList.add(num);
                if(num != 0){
                    if(prevNum == -1)
                        prevNum = num;
                    else {
                        if(prevNum != num) {
                            currentNumList.add(prevNum);
                            prevNum = num;
                        }
                        else {
                            currentNumList.add(num * 2);
                            recordScore(num * 2);
                            prevNum = -1;
                        }
                    }
                }
            }
            if(prevNum != -1){
                currentNumList.add(prevNum);
            }
            for(int j = currentNumList.size(); j < columnCnt; j++){
                currentNumList.add(0);
            }
            if(!currentNumList.equals(prevNumList)){
                merge = true;
            }
            prevNumList.clear();
            for(int j = columnCnt - 1; j >= 0; j--){
                cells[i][j].setNum(currentNumList.get(columnCnt - j - 1));
            }
            currentNumList.clear();
            prevNum = -1;
        }
        if(merge){
            setNum();
            check();
        }
    }

    private void swipeLeft() {
        boolean merge = false;
        for(int i = 0; i < columnCnt; i++){
            for(int j = 0; j < columnCnt; j++) {
                int num = cells[i][j].getNum();
                prevNumList.add(num);
                if(num != 0){
                    if(prevNum == -1)
                        prevNum = num;
                    else {
                        if(prevNum != num) {
                            currentNumList.add(prevNum);
                            prevNum = num;
                        }
                        else {
                            currentNumList.add(num * 2);
                            recordScore(num * 2);
                            prevNum = -1;
                        }
                    }
                }
            }
            if(prevNum != -1){
                currentNumList.add(prevNum);
            }
            for(int j = currentNumList.size(); j < columnCnt; j++){
                currentNumList.add(0);
            }
            if(!currentNumList.equals(prevNumList)){
                merge = true;
            }
            prevNumList.clear();
            for(int j = 0; j < currentNumList.size(); j++){
                cells[i][j].setNum(currentNumList.get(j));
            }
            currentNumList.clear();
            prevNum = -1;
        }
        if(merge){
            setNum();
            check();
        }
    }

    private void check() {
        getEmptyCell();
        if(emptyCellPoint.size() == 0){
            if(win){
                return;
            }
        }
    }

    private void recordScore(int score) {
        Intent intent = new Intent("UPDATE_CURRENT_SCORE");
        intent.putExtra("SCORE", score);
        //TODO: 无法向MainActivity类传递信息
    }

    private int getSwipeDir(float offsetX, float offsetY) {
        if(Math.abs(offsetX) > 0 && Math.abs(offsetY) > 0){
            if(Math.abs(offsetX) > Math.abs(offsetY)){ // x axis
                if(offsetX < 0)
                    return 1; // left
                else
                    return 2; // right
            }
            else { // y axis
                if(offsetY > 0)
                    return 3; // up
                else
                    return 4; // down

            }
        }
        else // click
            return -1;
    }

    private void startGame() {
        resetView();
        ArrayList<CellPoint> data = new ArrayList<>();
        SQLiteDatabase db = gameDataBase.getWritableDatabase();
        Cursor cursor = db.query("G4", null, null, null,
                null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
            while (cursor.moveToNext()){
                @SuppressLint("Range") int x = cursor.getInt(cursor.getColumnIndex("x"));
                @SuppressLint("Range") int y = cursor.getInt(cursor.getColumnIndex("y"));
                @SuppressLint("Range") int num =cursor.getInt(cursor.getColumnIndex("num"));
                data.add(new CellPoint(x, y, num));
            }
            cursor.close();
        }
        if(data.size() <= 2)
            initGame();
        else 
            resume(data);
    }

    private void initGame() {
        setNum();
        setNum();
    }

    private void setNum() {
        getEmptyCell();
        if(emptyCellPoint.size() > 0){
            CellPoint cellPoint = emptyCellPoint.get((int)(Math.random() * emptyCellPoint.size()));
            cells[cellPoint.getX()][cellPoint.getY()].setNum(Math.random() >= 0.5 ? 2 : 4);
            //TODO 出现的动画
        }
    }

    private void getEmptyCell() {
        emptyCellPoint.clear();
        for(int i = 0; i < columnCnt; i++){
            for(int j = 0; j < columnCnt; j++){
                if(cells[i][j].getNum() == 2048)
                    win = true;
                if(cells[i][j].getNum() < 2)
                    emptyCellPoint.add(new CellPoint(i, j, 0));
            }
        }
    }

    private void resume(ArrayList<CellPoint> data) {
        for(CellPoint point : data){
            cells[point.getX()][point.getY()].setNum(point.getNum());
            //TODO 出现的动画
        }
    }

    private void resetView() {
        for(int i = 0;i < columnCnt;i++)
            for(int j =0;j < columnCnt;j++)
                cells[i][j].setNum(0);
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

    public void reset(){
        resetView();
        setNum();
        setNum();
    }
}
