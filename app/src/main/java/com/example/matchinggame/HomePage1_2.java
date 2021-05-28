package com.example.matchinggame;

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

import java.text.DecimalFormat;

public class HomePage1_2 extends AppCompatActivity {

    MediaPlayer BGM;
    Button btnLevel1, btnLevel2, btnLevel3, btnQuit;

    private View decorView;
    TextView textView;

    double score1;


    DecimalFormat df = new DecimalFormat("######0.0");

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page1_2);

        score1 = getIntent().getExtras().getDouble("Value1");

        BGM = MediaPlayer.create(HomePage1_2.this,R.raw.bgm_wel);
        BGM.start();

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0) {
                decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
        Animation animation= AnimationUtils.loadAnimation(HomePage1_2.this,R.anim.bounce);


        textView = findViewById(R.id.textView);

        textView.startAnimation(animation);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.but_letsgo);
        btnLevel1 = findViewById(R.id.level_1);
        btnLevel2 = findViewById(R.id.level_2);
        btnLevel3 = findViewById(R.id.level_3);
        btnQuit = findViewById(R.id.exit);

        btnLevel1.setText("Level-1\nScore: "+df.format(score1));

        btnLevel1.setOnClickListener(v -> {
            showRes();
            hideSystemBars();
        });



        btnLevel2.setOnClickListener(v -> {
            hideSystemBars();
            mp.start();
            Intent intent = new Intent(getApplicationContext(), MainActivityL2.class);
            intent.putExtra("Value1",score1);
            startActivity(intent);
            finish();
        });

        btnLevel3.setOnClickListener(v -> showMsg());

        btnQuit.setOnClickListener(v -> finish());

    }

    @SuppressLint("SetTextI18n")
    public void showRes()
    {
        final Dialog dialog=new Dialog(HomePage1_2.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.result_dialog);
        Button sure_guide=dialog.findViewById(R.id.sure_guide);
        TextView resultShow=dialog.findViewById(R.id.resultShow);
        resultShow.setText("Your Level 1 score is: "+df.format(score1)+"\nConquer the next level");
        sure_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @SuppressLint("SetTextI18n")
    public void showMsg()
    {
        final Dialog dialog=new Dialog(HomePage1_2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.msg_dialog);
        Button sure_guide=dialog.findViewById(R.id.sure_guide);
        TextView resultShow=dialog.findViewById(R.id.msgShow);
        resultShow.setText("Please pass Level 2 first");

        sure_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
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
    protected void onResume()
    {
        super.onResume();

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        BGM.release();
        finish();
    }

}
