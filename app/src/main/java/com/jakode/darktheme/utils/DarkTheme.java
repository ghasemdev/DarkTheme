package com.jakode.darktheme.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class DarkTheme {
    private SharedPreferences pref;
    private final static String STATUS = "uiMode";

    public DarkTheme(Context context) {
        pref = context.getSharedPreferences("DarkTheme", Context.MODE_PRIVATE);
    }

    public Boolean getMode() {
        return pref.getBoolean(STATUS, false);
    }

    public void setMode(Boolean mode) {
        pref.edit().putBoolean(STATUS, mode).apply();
    }

    public void checkTheme() {
        if (getMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
