package com.jakode.darktheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.jakode.darktheme.utils.DarkTheme;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Switch switchBtn = findViewById(R.id.switchBtn);
        if (Build.VERSION.SDK_INT < 29) {
            switchBtn.setChecked(new DarkTheme(this).getMode());

            switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (!isChecked) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        new DarkTheme(SecondActivity.this).setMode(false);
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        new DarkTheme(SecondActivity.this).setMode(true);
                    }
                }
            });
        } else {
            switchBtn.setVisibility(View.GONE);
        }
    }
}