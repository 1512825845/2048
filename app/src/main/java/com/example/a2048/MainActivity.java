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
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import com.example.a2048.util.DensityUtil;

public class MainActivity extends AppCompatActivity {
    public TextView tvScore;
    public TextView tvBestScore;
    public int score = 0;
    private int bestScores;
//    private Button bt;

    private static MainActivity mainActivity = null;
    public MainActivity(){
        mainActivity = this;
    }
    public static MainActivity getMainActivity(){
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int width = DensityUtil.getScreenWidth(this);
        int height = DensityUtil.getScreenHeight(this);
        ImageView bg_img = (ImageView) findViewById(R.id.bg_image);
        ViewGroup.LayoutParams params = bg_img.getLayoutParams();
        params.width = width;
        params.height = height;
        bg_img.setLayoutParams(params);
        bg_img.setImageResource(R.drawable.bg);

//        inital();
    }

//    @SuppressLint("SetTextI18n")
//    public void inital(){
//        tvBestScore = (TextView) findViewById(R.id.maxSorce);
//        tvScore = (TextView) findViewById(R.id.tvSorce);
////        bt = (Button) findViewById(R.id.bt_cx);
////        bt.setOnClickListener(this::onClick);
//        BastScode bastScode = new BastScode(this);
//        bestScores = bastScode.getBastScode();
//        tvBestScore.setText(bestScores+"");
//    }
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.main,menu);
//        return true;
//    }
//    public void onClick1(View v){
//        GameView.getGameView().startGame();
//    }
//public void onClick(View view){
//    switch (view.getId()){
//        case R.id.btnquit:
//            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//            dialog.setTitle("提示：");
//            dialog.setMessage("你确定要离开吗？");
//            dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    System.exit(0);
//                }
//            });
//            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//                }
//            });
//            dialog.show();
//            break;
//        case R.id.btnrestart:
//            AlertDialog.Builder dialog3 = new AlertDialog.Builder(this);
//            dialog3.setTitle("提示：");
//            dialog3.setMessage("你确定重新开始吗？");
//            dialog3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//                }
//            });
//            dialog3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//                }
//            });
//            dialog3.show();
//            break;
//        default:break;
//    }
//}
//    public void clearScore(){
//        score = 0;
//        showScore();
//    }
//    public void showScore(){
//        tvScore.setText(score+"");
//    }
//    public void addScore(int s){
//        score+=s;
//        showScore();
//        if(score>bestScores){
//            bestScores = score;
//            BastScode bs = new BastScode(this);
//            bs.setBestScode(bestScores);
//            tvBestScore.setText(bestScores+"");
//        }
//    }

//    private long exitTime = 0;
//    @SuppressLint("WrongConstant")
//    public boolean onKeyDown(int keyCode,KeyEvent event){
//        if (keyCode==KeyEvent.KEYCODE_BACK
//                &&event.getAction() == KeyEvent.ACTION_DOWN){
//            if ((System.currentTimeMillis() - exitTime)>2000){
//                Toast.makeText(this,"再次点击退出游戏",1000).show();
//                exitTime = System.currentTimeMillis();
//            }else {
//                finish();
//                System.exit(0);
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

}