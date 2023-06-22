package com.example.a10120062sensor;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
/**
 * 10120062
 * Ahmad Sanosi
 * IF-2
 */
    @SuppressLint("CustomSplashScreen")
    public class Splash_Screen extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //menghilangkan ActionBar
            this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_splash_screen);

            final Handler handler = new Handler();
            handler.postDelayed(() -> {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }, 4000L); //4000L = 4 detik
        }
    }
