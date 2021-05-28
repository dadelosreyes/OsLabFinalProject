package com.example.matchinggame;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class GameOverScreen extends AppCompatActivity {

    MediaPlayer endBgm;
    Button btnRestart;
    Button btnQuit;
    private View decorView;
    double score3;
    TextView textView, textView1;
    ImageView imageView;
    DecimalFormat df = new DecimalFormat("######0.00");

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ending_screen);

        score3 = getIntent().getExtras().getDouble("Value3");

        endBgm = MediaPlayer.create(GameOverScreen.this,R.raw.end_sfx);
        endBgm.start();

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility ->
        {
            if (visibility == 0) {
                decorView.setSystemUiVisibility(hideSystemBars());
            }
        });

        Animation animation= AnimationUtils.loadAnimation(GameOverScreen.this,R.anim.bounce);
        Animation animation2= AnimationUtils.loadAnimation(GameOverScreen.this,R.anim.mixed_anim);

        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.gif);

        imageView.startAnimation(animation2);

        textView1.setText("Your score is \n"+df.format(score3));
        textView.startAnimation(animation);
        textView1.startAnimation(animation);

        btnRestart = findViewById(R.id.restart);
        btnQuit = findViewById(R.id.quit);

        btnRestart.setOnClickListener(v ->
        {
            Intent intent = new Intent(getApplicationContext(), HomePage.class);
            startActivity(intent);
            finish();
        });

        btnQuit.setOnClickListener(v -> finish());

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars()
    {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        endBgm.release();
        finish();
    }
}
