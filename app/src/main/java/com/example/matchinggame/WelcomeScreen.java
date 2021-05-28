package com.example.matchinggame;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    MediaPlayer BGM;
    Button btnPlay, btnInstructions;
    MediaPlayer GREET;

    private View decorView;
    TextView img_ewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        BGM = MediaPlayer.create(WelcomeScreen.this,R.raw.bgm_wel);
        BGM.start();
        btnPlay = findViewById(R.id.button);
        btnInstructions = findViewById(R.id.instructions);

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0)
            {
                decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
        Animation animation= AnimationUtils.loadAnimation(WelcomeScreen.this,R.anim.bounce);

        img_ewan = findViewById(R.id.level1);
        img_ewan.startAnimation(animation);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.but_letsgo);

        btnPlay.setOnClickListener(v ->
        {
            mp.start();
            startActivity(new Intent(WelcomeScreen.this,HomePage.class));
        });
        btnInstructions.setOnClickListener(v -> {
            showGuide();
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }
    public void showGuide()
    {
        final Dialog dialog=new Dialog(WelcomeScreen.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.instructions_dialog);

        Button btnHome = dialog.findViewById(R.id.home_guide);
        Button btnGuide = dialog.findViewById(R.id.sure_guide);

        btnHome.setOnClickListener(v -> {
            startActivity(new Intent(WelcomeScreen.this,HomePage.class));
            finish();
        });
        btnGuide.setOnClickListener(v -> {
            GREET = MediaPlayer.create(WelcomeScreen.this,R.raw.but_goodluck);
            GREET.start();
            dialog.dismiss();
        });
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        BGM.release();
        finish();
    }
}
