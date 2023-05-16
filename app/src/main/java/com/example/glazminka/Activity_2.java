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
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Activity_2 extends AppCompatActivity {
    private MainActivity mainActivity;
    boolean isImageVisible = false;
    boolean isImageChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ImageView imageView = findViewById(R.id.imageView);
        ImageView sound = findViewById(R.id.sound_1);


        Button btnGoToActivity = (Button) findViewById(R.id.btnGoToActivity);
        Button number_1 = (Button) findViewById(R.id.number1);
        Button number_2 = (Button) findViewById(R.id.number2);
        Button number_3 = (Button) findViewById(R.id.number3);
        Button number_4 = (Button) findViewById(R.id.number4);
        TextView textView = findViewById(R.id.exercise_text);
        ImageButton text = (ImageButton) findViewById(R.id.text);



        View.OnClickListener oclBtnGoToActivity = new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Activity_2.this, MainActivity.class);
                startActivity(intent);
            }
        };
        btnGoToActivity.setOnClickListener(oclBtnGoToActivity);

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isImageVisible) {
                    sound.setImageResource(R.drawable.sound_1);

                } else {
                    sound.setImageResource(R.drawable.sound_2);
                }
                isImageVisible=!isImageVisible;

            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isImageChanged) {
                    text.setImageResource(R.drawable.text1);
                    textView.setVisibility(View.INVISIBLE);

                } else {
                    text.setImageResource(R.drawable.text);
                    textView.setVisibility(View.VISIBLE);
                }
                isImageChanged = !isImageChanged;

            }
        });




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
                Animation.RELATIVE_TO_SELF, -3.7f
        );
        upAnimation.setDuration(2000);
        upAnimation.setFillAfter(true);

        TranslateAnimation rightAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 3.7f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f
        );
        rightAnimation.setDuration(2000);
        rightAnimation.setFillAfter(true);

        TranslateAnimation downAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 3.7f
        );
        downAnimation.setDuration(2000);
        downAnimation.setFillAfter(true);

        TranslateAnimation leftAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -3.7f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f
        );
        leftAnimation.setDuration(2000);
        leftAnimation.setFillAfter(true);

        TranslateAnimation diagonalAnimationLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 3.7f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 3.7f);
        diagonalAnimationLeft.setDuration(2000);
        diagonalAnimationLeft.setFillAfter(true);
        TranslateAnimation diagonalAnimationRigh = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -3.7f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 3.7f);
        diagonalAnimationRigh.setDuration(2000);
        diagonalAnimationRigh.setFillAfter(true);




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
                        "Смотрим вниз в правый угол, поднимаем глаза, затем переносим взгляд в левый верхний угол," +
                        " вниз, возвращаемся в исходную точку. Повторим. вниз вправо, наверх, влево, вниз, вправо. и в другую сторону");
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.gravity = Gravity.BOTTOM | Gravity.LEFT;
                imageView.setLayoutParams(layoutParams);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        imageView.startAnimation(rightAnimation);
                    }
                }, 1000);

                new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long l) {}

                    @Override
                    public void onFinish() {
                        imageView.clearAnimation();
                        layoutParams.gravity = Gravity.BOTTOM | Gravity.RIGHT;
                        imageView.setLayoutParams(layoutParams);
                        imageView.startAnimation(upAnimation);

                        new CountDownTimer(10000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }

                            @Override
                            public void onFinish() {
                                imageView.clearAnimation();
                                layoutParams.gravity = Gravity.TOP | Gravity.RIGHT;
                                imageView.setLayoutParams(layoutParams);
                                imageView.startAnimation(leftAnimation);

                                new CountDownTimer(5000, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                    }

                                    @Override
                                    public void onFinish() {
                                        imageView.clearAnimation();
                                        layoutParams.gravity = Gravity.TOP | Gravity.LEFT;
                                        imageView.setLayoutParams(layoutParams);
                                        imageView.startAnimation(downAnimation);

                                        new CountDownTimer(5000, 1000) {
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
                        }.start();
                    }
                }.start();

            }
        });

        number_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Рисуем глазами бантики. \n" +
                        "Начиная от правого верхнего угла опускаем глаза вниз, по диагонали поднимем взгляд в верхний левый угол, опускаем и возвращаемся на исходную точку.\n");
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.gravity = Gravity.BOTTOM | Gravity.LEFT;
                imageView.setLayoutParams(layoutParams);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.startAnimation(upDownAnimation);
                    }
                }, 1000);

                new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        imageView.clearAnimation();

                        layoutParams.gravity = Gravity.TOP | Gravity.LEFT;
                        imageView.setLayoutParams(layoutParams);
                        imageView.startAnimation(diagonalAnimationLeft);

                        new CountDownTimer(5000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }

                            @Override
                            public void onFinish() {
                                imageView.clearAnimation();
                                layoutParams.gravity = Gravity.BOTTOM | Gravity.RIGHT;
                                imageView.setLayoutParams(layoutParams);
                                imageView.startAnimation(upAnimation);

                                new CountDownTimer(5000, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                    }

                                    @Override
                                    public void onFinish() {
                                        imageView.clearAnimation();
                                        layoutParams.gravity = Gravity.TOP | Gravity.RIGHT;
                                        imageView.setLayoutParams(layoutParams);
                                        imageView.startAnimation(diagonalAnimationRigh);

                                        new CountDownTimer(5000, 1000) {
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
                        }.start();
                    }
                }.start();
            }
        });


    }
}