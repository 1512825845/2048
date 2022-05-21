package com.example.a2048;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;


import android.content.Context;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
//import android.view.KeyEvent;
//import android.os.TokenWatcher;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.a2048.util.ScoreUtil;
import com.example.a2048.util.DensityUtil;
import com.example.a2048.view.GameOverDialog;
import com.example.a2048.view.GameView;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView currentScore;
    private TextView bestScores;
    private TextView titleDescribe;
    private TextView bestRank;
    private MaterialButton reset;
    private GameView gameView;
    public ScoreUtil scoreUtil;
    private String id;
    public GameOverDialog gameOverDialog;
    private MaterialButton again;
    private MaterialButton goOn;

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
        initBg(this);
        initView();
    }

    private void initView() {
        if(isLightColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
        else {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
        id = "root";
        titleDescribe = findViewById(R.id.tv_title_describe);
        currentScore = findViewById(R.id.tv_current_score);
        bestScores = findViewById(R.id.tv_best_score);
        bestRank = findViewById(R.id.tv_best_rank);
        reset = findViewById(R.id.btn_reset);
        gameView = findViewById(R.id.game_view);

        gameOverDialog = new GameOverDialog(this, R.style.Theme_2048);

        scoreUtil = new ScoreUtil(this);
        if(scoreUtil.getScore(id, "best") <= 0) {
            scoreUtil.insertScore(id, "best","current" , 0, 0);
        }

        scoreUtil.setScore(id, "current", 0);

        bestScores.setText(String.valueOf(scoreUtil.getScore(id, "best")));
        bestRank.setText(getString(R.string.best_score_rank));
        currentScore.setText(String.valueOf(scoreUtil.getScore(id, "current")));
        gameView.init();

        setTextStyle(titleDescribe);
        reset.setOnClickListener(this);

        again = LayoutInflater.from(this).
                inflate(R.layout.game_over_dialog, null).findViewById(R.id.tv_reset);

        goOn = LayoutInflater.from(this).
                inflate(R.layout.game_over_dialog, null).findViewById(R.id.tv_go_on);

        again.setOnClickListener(this);
        goOn.setOnClickListener(this);
    }

    private void setTextStyle(TextView titleDescribe) {
        SpannableString spannableString = new SpannableString(titleDescribe.getText().toString());
        StyleSpan styleSpan = new StyleSpan(Typeface.ITALIC);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#363c48"));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(36);
        spannableString.setSpan(styleSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(foregroundColorSpan, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(absoluteSizeSpan, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        titleDescribe.setText(spannableString);
    }

    private void initBg(Context context) {
        int width = DensityUtil.getScreenWidth(context);
        int height = DensityUtil.getScreenHeight(context);
        ImageView bg_img = findViewById(R.id.bg_image);
        ViewGroup.LayoutParams params = bg_img.getLayoutParams();
        params.width = width;
        params.height = height;
        bg_img.setLayoutParams(params);
        bg_img.setImageResource(R.drawable.bg);
    }

    private boolean isLightColor(int color) {
        return ColorUtils.calculateLuminance(color) >= 0.5;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_reset:
                gameView.reset();
                break;
            default:
                break;
        }
    }

    public void GameOver(View v){
        switch (v.getId()){
            case R.id.tv_reset:
                gameView.reset();
                gameOverDialog.dismiss();
                break;
            case R.id.tv_go_on:
                gameOverDialog.dismiss();
                break;
            default:
                break;
        }
    }

}