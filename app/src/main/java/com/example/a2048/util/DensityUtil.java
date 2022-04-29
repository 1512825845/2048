package com.example.a2048.util;

import android.content.Context;
import android.util.DisplayMetrics;

public class DensityUtil {
    public static float RATIO = 0.95F;//缩放比例值

    public static int px2dipRatio(Context context, float pxValue) {
        float scale = getScreenDendity(context) * RATIO;
        return (int)((pxValue / scale) + 0.5f);
    }


    public static int dip2pxRatio(Context context, float dpValue) {
        float scale = getScreenDendity(context) * RATIO;
        return (int)((dpValue * scale) + 0.5f);
    }


    public static int px2dip(Context context, float pxValue) {
        float scale = getScreenDendity(context);
        return (int)((pxValue / scale) + 0.5f);
    }


    public static int dip2px(Context context, float dpValue) {
        float scale = getScreenDendity(context);
        return (int)((dpValue * scale) + 0.5f);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;//1080
    }

    public static int getScreenWidthDp(Context context) {
        float scale = getScreenDendity(context);
        return (int)(context.getResources().getDisplayMetrics().widthPixels / scale);//360
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;//1776
    }

    public static int getScreenHeightDp(Context context) {
        float scale = getScreenDendity(context);
        return (int)(context.getResources().getDisplayMetrics().heightPixels / scale);//592
    }
    public static float getScreenDendity(Context context){
        return context.getResources().getDisplayMetrics().density;//3
    }

    public static int getStatusBarHeight(Context context) {
        int statusHeight = -1;
        try {
            Class<?> aClass = Class.forName("com.android.internal.R$dimen");
            Object object = aClass.newInstance();
            int height = Integer.parseInt(aClass.getField("status_bar_height").get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }


    public static int dpToPx(Context context, int dp) {
        return Math.round(((float)dp * getPixelScaleFactor(context)));
    }

    public static int dp2px(Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (12 * scale + 0.5f);
    }


    public static int pxToDp(Context context, int px) {
        return Math.round(((float)px / getPixelScaleFactor(context)));
    }


    public static float getPixelScaleFactor(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (displayMetrics.xdpi / 160.0f);
    }
}