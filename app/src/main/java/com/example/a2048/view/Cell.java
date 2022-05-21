package com.example.a2048.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.a2048.R;
import com.example.a2048.util.DensityUtil;

public class Cell extends FrameLayout {

    private TextView showNumber;
    private int num;
    public boolean canMerge;
    private final ScaleAnimation animation = new ScaleAnimation(0.7f, 1f, 0.7f, 1f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    public Cell(@NonNull Context context) {
        super(context);
        showNumber = new TextView(context);
        showNumber.setTextSize(36);
        showNumber.setGravity(Gravity.CENTER);
        showNumber.getPaint().setAntiAlias(true);
        showNumber.getPaint().setFakeBoldText(true);
        showNumber.setTextColor(ContextCompat.getColor(context, R.color.colorWhiteDim));
        showNumber.setBackgroundResource(R.drawable.bg_cell);
        LayoutParams params = new LayoutParams(-1, -1);
        params.setMargins(DensityUtil.dp2px(context), DensityUtil.dp2px(context), 0, 0);
        addView(showNumber, params);
        setNum(0);
        canMerge = false;
    }

    public void setNum(int x){
        this.num = x;
        showNumber.setBackgroundTintList(ColorStateList.valueOf(getBackgroundColor(x)));
        if(x < 0){
            showNumber.setText("ERROR");
        }
        else if(x == 0){
            showNumber.setText("");
        }
        else {
            showNumber.setText(String.valueOf(x));
        }
    }

    public int getNum() {
        return num;
    }

    private int getBackgroundColor(int x){
        switch (x){
            case 0:
                return ContextCompat.getColor(getContext(), R.color.cell_0);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.cell_2);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.cell_4);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.cell_8);
            case 16:
                return ContextCompat.getColor(getContext(), R.color.cell_16);
            case 32:
                return ContextCompat.getColor(getContext(), R.color.cell_32);
            case 64:
                return ContextCompat.getColor(getContext(), R.color.cell_64);
            case 128:
                return ContextCompat.getColor(getContext(), R.color.cell_128);
            case 256:
                return ContextCompat.getColor(getContext(), R.color.cell_256);
            case 512:
                return ContextCompat.getColor(getContext(), R.color.cell_512);
            case 1024:
                return ContextCompat.getColor(getContext(), R.color.cell_1024);
            case 2048:
                return ContextCompat.getColor(getContext(), R.color.cell_2048);
            default:
                return ContextCompat.getColor(getContext(), R.color.cell_default);
        }
    }

    public TextView getCell(){
        return showNumber;
    }

    public void animation(){
        animation.setDuration(100);
        this.startAnimation(animation);
    }
}
