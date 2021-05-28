package com.example.matchinggame;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    MediaPlayer BGM;
    MediaPlayer GREET;
    MediaPlayer highScore;
    MediaPlayer wrong;
    MediaPlayer correct;

    Button btnRestart;
    Button btnHome;
    private View decorView;
    TextView txtTries, txtCorrect;
    TextView score;
    ImageView img_1, img_2, img_3, img_4, img_5, img_6, img_7, img_8, img_9, img_10, img_11, img_12;

    Integer [] cardsArray = {1,2,3,4,5,6,7,8,9,10,11,12};
    int image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12;

    int firstCard, secondCard;
    int clickFirst, clickSecond;
    int cardNumber = 1;

    int playerPoints = 0, cpuPoints = 0;

    DecimalFormat df = new DecimalFormat("######0.0");
    double score1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        BGM = MediaPlayer.create(MainActivity.this,R.raw.bgm_l1);
        BGM.start();

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0) {
                decorView.setSystemUiVisibility(hideNotifications());
            }
        });

        btnRestart = findViewById(R.id.restart);
        btnRestart.setOnClickListener(v -> {
            hideNotifications();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        });

        btnHome = findViewById(R.id.home);
        btnHome.setOnClickListener(v -> {
            hideNotifications();
            startActivity(new Intent(MainActivity.this,HomePage.class));
            finish();
        });

        txtTries = findViewById(R.id.tries);
        txtCorrect = findViewById(R.id.correct);
        score = findViewById(R.id.score);

        img_1 = findViewById(R.id.im_1);
        img_2 = findViewById(R.id.im_2);
        img_3 = findViewById(R.id.im_3);
        img_4 = findViewById(R.id.im_4);
        img_5 = findViewById(R.id.im_5);
        img_6 = findViewById(R.id.im_6);
        img_7 = findViewById(R.id.im_7);
        img_8 = findViewById(R.id.im_8);
        img_9 = findViewById(R.id.im_9);
        img_10 = findViewById(R.id.im_10);
        img_11 = findViewById(R.id.im_11);
        img_12 = findViewById(R.id.im_12);

        img_1.setTag("0");
        img_2.setTag("1");
        img_3.setTag("2");
        img_4.setTag("3");
        img_5.setTag("4");
        img_6.setTag("5");
        img_7.setTag("6");
        img_8.setTag("7");
        img_9.setTag("8");
        img_10.setTag("9");
        img_11.setTag("10");
        img_12.setTag("11");

        setImages();
        Collections.shuffle(Arrays.asList(cardsArray));

        img_1.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_1, theCard);
        });

        img_2.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_2, theCard);
        });

        img_3.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_3, theCard);
        });

        img_4.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_4, theCard);
        });

        img_5.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_5, theCard);
        });

        img_6.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_6, theCard);
        });

        img_7.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_7, theCard);
        });

        img_8.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_8, theCard);
        });

        img_9.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_9, theCard);
        });

        img_10.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_10, theCard);
        });

        img_11.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_11, theCard);
        });

        img_12.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            SetImage(img_12, theCard);
        });

    }

    private void SetImage(ImageView iv, int card)
    {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.tap_sound);
        mp.start();
        if (cardsArray[card] == 1)
        {
            iv.setImageResource(image1);
        }
        else if (cardsArray[card] == 2)
        {
            iv.setImageResource(image2);
        }
        else if (cardsArray[card] == 3)
        {
            iv.setImageResource(image3);
        }
        else if (cardsArray[card] == 4)
        {
            iv.setImageResource(image4);
        }
        else if (cardsArray[card] == 5)
        {
            iv.setImageResource(image5);
        }
        else if (cardsArray[card] == 6)
        {
            iv.setImageResource(image6);
        }
        else if (cardsArray[card] == 7)
        {
            iv.setImageResource(image7);
        }
        else if (cardsArray[card] == 8)
        {
            iv.setImageResource(image8);
        }
        else if (cardsArray[card] == 9)
        {
            iv.setImageResource(image9);
        }
        else if (cardsArray[card] == 10)
        {
            iv.setImageResource(image10);
        }
        else if (cardsArray[card] == 11)
        {
            iv.setImageResource(image11);
        }
        else if (cardsArray[card] == 12)
        {
            iv.setImageResource(image12);
        }

        if (cardNumber == 1)
        {
            firstCard = cardsArray[card];
            if (firstCard > 6) {
                firstCard = firstCard - 6;
            }
            cardNumber = 2;
            clickFirst = card;

            iv.setEnabled(false);
        }
        else if (cardNumber == 2)
        {
            secondCard = cardsArray[card];
            if (secondCard > 6)
            {
                secondCard = secondCard - 6;
            }
            cardNumber = 1;
            clickSecond = card;

            img_1.setEnabled(false);
            img_2.setEnabled(false);
            img_3.setEnabled(false);
            img_4.setEnabled(false);
            img_5.setEnabled(false);
            img_6.setEnabled(false);
            img_7.setEnabled(false);
            img_8.setEnabled(false);
            img_9.setEnabled(false);
            img_10.setEnabled(false);
            img_11.setEnabled(false);
            img_12.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            },700);
        }
    }

    @SuppressLint("SetTextI18n")
    private void calculate()
    {
        Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.sample_anim);
        Animation animation2= AnimationUtils.loadAnimation(MainActivity.this,R.anim.sample_anim2);
        if (firstCard == secondCard)
        {
            if (clickFirst == 0)
            {
                img_1.startAnimation(animation);
                img_1.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 1)
            {
                img_2.startAnimation(animation);
                img_2.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 2)
            {
                img_3.startAnimation(animation);
                img_3.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 3)
            {
                img_4.startAnimation(animation);
                img_4.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 4)
            {
                img_5.startAnimation(animation);
                img_5.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 5)
            {
                img_6.startAnimation(animation);
                img_6.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 6)
            {
                img_7.startAnimation(animation);
                img_7.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 7)
            {
                img_8.startAnimation(animation);
                img_8.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 8)
            {
                img_9.startAnimation(animation);
                img_9.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 9)
            {
                img_10.startAnimation(animation);
                img_10.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 10)
            {
                img_11.startAnimation(animation);
                img_11.setVisibility(View.INVISIBLE);
            }
            else if (clickFirst == 11)
            {
                img_12.startAnimation(animation);
                img_12.setVisibility(View.INVISIBLE);
            }

            if (clickSecond == 0)
            {
                img_1.startAnimation(animation2);
                img_1.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 1)
            {
                img_2.startAnimation(animation2);
                img_2.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 2)
            {
                img_3.startAnimation(animation2);
                img_3.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 3)
            {
                img_4.startAnimation(animation2);
                img_4.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 4)
            {
                img_5.startAnimation(animation2);
                img_5.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 5)
            {
                img_6.startAnimation(animation2);
                img_6.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 6)
            {
                img_7.startAnimation(animation2);
                img_7.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 7)
            {
                img_8.startAnimation(animation2);
                img_8.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 8)
            {
                img_9.startAnimation(animation2);
                img_9.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 9)
            {
                img_10.startAnimation(animation2);
                img_10.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 10)
            {
                img_11.startAnimation(animation2);
                img_11.setVisibility(View.INVISIBLE);
            }
            else if (clickSecond == 11)
            {
                img_12.startAnimation(animation2);
                img_12.setVisibility(View.INVISIBLE);
            }

            correct = MediaPlayer.create(MainActivity.this,R.raw.match_sfx);
            correct.start();

            playerPoints++;
            txtCorrect.setText("Correct: "+playerPoints);

        }
        else
        {

            img_1.setImageResource(R.drawable.cover);
            img_2.setImageResource(R.drawable.cover);
            img_3.setImageResource(R.drawable.cover);
            img_4.setImageResource(R.drawable.cover);
            img_5.setImageResource(R.drawable.cover);
            img_6.setImageResource(R.drawable.cover);
            img_7.setImageResource(R.drawable.cover);
            img_8.setImageResource(R.drawable.cover);
            img_9.setImageResource(R.drawable.cover);
            img_10.setImageResource(R.drawable.cover);
            img_11.setImageResource(R.drawable.cover);
            img_12.setImageResource(R.drawable.cover);

            wrong = MediaPlayer.create(MainActivity.this,R.raw.mismatch);
            wrong.start();

        }

        cpuPoints++;
        txtTries.setText("Tries: "+cpuPoints);
        score.setText("Score: "+df.format(12 * (double)playerPoints/cpuPoints));

        img_1.setEnabled(true);
        img_2.setEnabled(true);
        img_3.setEnabled(true);
        img_4.setEnabled(true);
        img_5.setEnabled(true);
        img_6.setEnabled(true);
        img_7.setEnabled(true);
        img_8.setEnabled(true);
        img_9.setEnabled(true);
        img_10.setEnabled(true);
        img_11.setEnabled(true);
        img_12.setEnabled(true);

        checkEnd();
    }

    private void checkEnd()
    {
        if (img_1.getVisibility() == View.INVISIBLE &&
                img_2.getVisibility() == View.INVISIBLE &&
                img_3.getVisibility() == View.INVISIBLE &&
                img_4.getVisibility() == View.INVISIBLE &&
                img_5.getVisibility() == View.INVISIBLE &&
                img_6.getVisibility() == View.INVISIBLE &&
                img_7.getVisibility() == View.INVISIBLE &&
                img_8.getVisibility() == View.INVISIBLE &&
                img_9.getVisibility() == View.INVISIBLE &&
                img_10.getVisibility() == View.INVISIBLE &&
                img_11.getVisibility() == View.INVISIBLE &&
                img_12.getVisibility() == View.INVISIBLE)
        {
            highScore = MediaPlayer.create(MainActivity.this,R.raw.but_highscore);
            highScore.start();
            showReward();
        }
    }

    public void showGuide()
    {
        final Dialog dialog=new Dialog(MainActivity.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.instructions_dialog);

        Button btnHome = dialog.findViewById(R.id.home_guide);
        Button btnGuide = dialog.findViewById(R.id.sure_guide);

        btnHome.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,HomePage.class));
            finish();
        });
        btnGuide.setOnClickListener(v -> {
            GREET = MediaPlayer.create(MainActivity.this,R.raw.but_goodluck);
            GREET.start();
            dialog.dismiss();
        });
        dialog.show();
    }

    @SuppressLint("SetTextI18n")
    public void showReward()
    {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.win_sfx);
        mp.start();
        final Dialog dialog=new Dialog(MainActivity.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.reward_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnHome = dialog.findViewById(R.id.home_guide);
        Button BtnSure = dialog.findViewById(R.id.sure_guide);

        TextView txtPaired = dialog.findViewById(R.id.txt_paired);
        TextView txtTries = dialog.findViewById(R.id.tries);

        TextView txtAccuracy = dialog.findViewById(R.id.accuracy);
        TextView txtScore = dialog.findViewById(R.id.txt_score);

        txtPaired.setText("Number of paired: "+playerPoints);
        txtTries.setText("Number of tries: "+cpuPoints);

        txtAccuracy.setText("Accuracy: "+df.format ((double)playerPoints/cpuPoints));
        txtScore.setText("Score: "+df.format(12 * (double)playerPoints/cpuPoints));

        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HomePage1_2.class);
            score1 = 12 * (double)playerPoints/cpuPoints;
            intent.putExtra("Value1",score1);
            startActivity(intent);
            finish();
        });

        BtnSure.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivityL2.class);
            score1 = 12 * (double)playerPoints/cpuPoints;
            intent.putExtra("Value1",score1);
            startActivity(intent);
            finish();
        });
        dialog.show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideNotifications());
        }
    }
    private int hideNotifications()
    {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    private void setImages()
    {
        image1 = R.drawable.a1;
        image2 = R.drawable.a2;
        image3 = R.drawable.a3;
        image4 = R.drawable.a4;
        image5 = R.drawable.a5;
        image6 = R.drawable.a6;
        image7 = R.drawable.a1;
        image8 = R.drawable.a2;
        image9 = R.drawable.a3;
        image10 = R.drawable.a4;
        image11 = R.drawable.a5;
        image12 = R.drawable.a6;

    }
    //<a href="https://www.vecteezy.com/free-vector/animal-face">Animal Face Vectors by Vecteezy</a>

    @Override
    protected void onPause()
    {
        super.onPause();
        BGM.release();
        finish();
    }
}
