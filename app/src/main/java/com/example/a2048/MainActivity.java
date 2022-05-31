package com.example.a2048;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;

import android.app.Activity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
//import android.view.KeyEvent;
//import android.os.TokenWatcher;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public TextView tvScore;
    public TextView tvBestScore;
    public int score = 0;
    private int bestScores;


    private static MainActivity mainActivity = null;
    public MainActivity(){
        mainActivity = this;
    }
    public static MainActivity getMainActivity(){
        return mainActivity;
    }
    //初始化
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inital();
    }
    //初始化显示界面
    @SuppressLint("SetTextI18n")
    public void inital(){
        tvBestScore = (TextView) findViewById(R.id.maxSorce);
        tvScore = (TextView) findViewById(R.id.tvSorce);

        TopScore bastScode = new TopScore(this);
        bestScores = bastScode.getTopScore();
        tvBestScore.setText(bestScores+"");
    }
    //创建选项菜单
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    //实现简单按键功能
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnquit:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("提示：");
                dialog.setMessage("你确定要离开吗？");
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            case R.id.btnrestart:
                AlertDialog.Builder dialog3 = new AlertDialog.Builder(this);
                dialog3.setTitle("提示：");
                dialog3.setMessage("你确定重新开始吗？");
                dialog3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        GameView.startGame();
                    }
                });
                dialog3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog3.show();
                break;
            default:break;
        }
    }
    //清空分数
    public void clearScore(){
        score = 0;
        showScore();
    }
    //显示分数
    public void showScore(){
        tvScore.setText(score+"");
    }
    //分数更新
    public void addScore(int s){
        score+=s;
        showScore();
        if(score>bestScores){
            bestScores = score;
            TopScore bs = new TopScore(this);
            bs.setTopScore(bestScores);
            tvBestScore.setText(bestScores+"");
        }
    }



}