package com.example.flipmatch;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.example.matchinggame.R;

public class HomePage extends AppCompatActivity {

    MediaPlayer BGM;
    Button btnLevel1, btnLevel2, btnLevel3, btnQuit;

    private View decorView;
    TextView textView;

    double score1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        BGM = MediaPlayer.create(HomePage.this,R.raw.bgm_wel);
        BGM.start();

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility ->
        {
            if (visibility == 0) {
                decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
        Animation animation= AnimationUtils.loadAnimation(HomePage.this,R.anim.bounce);
        textView = findViewById(R.id.level1);
        textView.startAnimation(animation);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.but_letsgo);
        btnLevel1 = findViewById(R.id.level_1);
        btnLevel2 = findViewById(R.id.level_2);
        btnLevel3 = findViewById(R.id.level_3);
        btnQuit = findViewById(R.id.exit);

        btnLevel1.setOnClickListener(v -> {
            mp.start();
            startActivity(new Intent(HomePage.this,MainActivity.class));
        });

        btnLevel2.setOnClickListener(v -> showMsg2());

        btnLevel3.setOnClickListener(v -> showMsg3());

        btnQuit.setOnClickListener(v -> finish());

    }

    @SuppressLint("SetTextI18n")
    public void showMsg2()
    {
        final Dialog dialog=new Dialog(HomePage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.msg_dialog);
        Button sure_guide=dialog.findViewById(R.id.sure_guide);
        TextView resultShow=dialog.findViewById(R.id.msgShow);
        resultShow.setText("Please pass Level-1 first");

        sure_guide.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    @SuppressLint("SetTextI18n")
    public void showMsg3()
    {
        final Dialog dialog=new Dialog(HomePage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.msg_dialog);
        Button sure_guide=dialog.findViewById(R.id.sure_guide);
        TextView resultShow=dialog.findViewById(R.id.msgShow);
        resultShow.setText("Please pass Level-2 first");

        sure_guide.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
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
