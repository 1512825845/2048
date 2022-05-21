package com.example.a2048.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.a2048.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class GameOverDialog extends Dialog {

    private String finalScore;
    private String title;
    public MaterialButton again;
    public MaterialButton goOn;


    public GameOverDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_dialog);

        setCancelable(false);
        setCanceledOnTouchOutside(false);

        Objects.requireNonNull(getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView title = findViewById(R.id.tv_custom_title);
        TextView finalScore = findViewById(R.id.tv_final_score);


        if (!TextUtils.isEmpty(this.finalScore)) {
            finalScore.setText(this.finalScore);
        }
        if (!TextUtils.isEmpty(this.title)) {
            title.setText(this.title);
        }
    }


    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }


    public void setTitle(String title) {
        this.title = title;
    }
}
