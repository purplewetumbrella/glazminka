package com.example.glazminka;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_2 extends AppCompatActivity {
    private MainActivity mainActivity;
    // изачально писала в одной активности, неуспела переписать в для разныч классов

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ImageView imageView = findViewById(R.id.imageView);

        Button btnGoToActivity = (Button) findViewById(R.id.btnGoToActivity);
        Button number_1 = (Button) findViewById(R.id.number1);
        Button number_2 = (Button) findViewById(R.id.number2);
        Button number_3 = (Button) findViewById(R.id.number3);
        Button number_4 = (Button) findViewById(R.id.number4);
        TextView textView = findViewById(R.id.exercise_text);


        View.OnClickListener oclBtnGoToActivity = new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Activity_2.this, MainActivity.class);
                startActivity(intent);
            }
        };
        btnGoToActivity.setOnClickListener(oclBtnGoToActivity);
        TranslateAnimation upDownAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -3.7f);
        upDownAnimation.setDuration(3000);
        upDownAnimation.setRepeatCount(Animation.INFINITE);
        upDownAnimation.setRepeatMode(Animation.REVERSE);

        TranslateAnimation diagonalAnimation1 = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 3.7f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -3.7f);
        diagonalAnimation1.setDuration(2000);
        diagonalAnimation1.setRepeatCount(Animation.INFINITE);
        diagonalAnimation1.setRepeatMode(Animation.REVERSE);
        TranslateAnimation diagonalAnimation2 = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -3.7f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -3.7f);
        diagonalAnimation2.setDuration(2000);
        diagonalAnimation2.setRepeatCount(Animation.INFINITE);
        diagonalAnimation2.setRepeatMode(Animation.REVERSE);
        TranslateAnimation upAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -3.7f);
        upDownAnimation.setDuration(3000);
        TranslateAnimation downAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 3.7f);
        upDownAnimation.setDuration(3000);
        TranslateAnimation leftAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -3.7f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f);
        upDownAnimation.setDuration(3000);
        TranslateAnimation rightAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 3.7f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f);
        upDownAnimation.setDuration(3000);


        number_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Чертим ровную линию глазами. " +
                        "Поднимем взгляд вверх, затем вниз и так несколько раз");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.startAnimation(upDownAnimation);
                    }
                }, 2000);

                new CountDownTimer(8000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        // Do nothing
                    }

                    @Override
                    public void onFinish() {
                        imageView.clearAnimation();
                    }
                }.start();
          }
        });
        number_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Рисуем глазами диагонали. " +
                        "Взгляд поднимем в верхний праву угол, перемещаем в нижний левый угол, поднимем вверх и спускаемся в правый нижний угол");
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.gravity = Gravity.BOTTOM | Gravity.LEFT;

                imageView.setLayoutParams(layoutParams);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.startAnimation(diagonalAnimation1);
                    }
                }, 1000);

                new CountDownTimer(10000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        imageView.clearAnimation();
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                        layoutParams.gravity = Gravity.BOTTOM | Gravity.RIGHT;
                        imageView.setLayoutParams(layoutParams);
                        imageView.startAnimation(diagonalAnimation2);

                        new CountDownTimer(10000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }

                            @Override
                            public void onFinish() {
                                imageView.clearAnimation();
                            }
                        }.start();
                    }
                }.start();
            }
        });
        number_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Нарисуем глазами квадрат.  " +
                        "Смотрим вниз в правый угол, поднимаем глаза, затем переносим взгляд в левый верхний угол, вниз, возвращаемся в исходную точку. Повторим. вниз вправо, наверх, влево, вниз, вправо. и в другую сторону");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.startAnimation(upAnimation);
                       /* imageView.startAnimation(leftAnimation);
                        imageView.startAnimation(downAnimation);
                        imageView.startAnimation(rightAnimation);
                        imageView.startAnimation(upAnimation);
                        imageView.startAnimation(leftAnimation);
                        imageView.startAnimation(downAnimation);
                        imageView.startAnimation(rightAnimation);*/
                    }
                }, 1000);

                new CountDownTimer(20000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        // Do nothing
                    }

                    @Override
                    public void onFinish() {
                        imageView.clearAnimation();
                    }
                }.start();
            }
        });
        number_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Рисуем глазами бантики. " +
                        "Начиная от правого верхнего угла опускаем глаза вниз, по диагонали поднимем взгляд в верхний левый угол, опускаем и возвращаемся на исходную точку");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.startAnimation(upDownAnimation);
                    }
                }, 2000);

                new CountDownTimer(8000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        imageView.clearAnimation();
                    }
                }.start();
            }
        });


    }
}