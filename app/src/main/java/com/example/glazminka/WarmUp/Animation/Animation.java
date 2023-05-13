package com.example.glazminka.WarmUp.Animation;

import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

public class Animation {
    TranslateAnimation upDownAnimation = new TranslateAnimation(
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, -3.7f);
        upDownAnimation.setDuration(3000);
        upDownAnimation.setRepeatCount(android.view.animation.Animation.INFINITE);
        upDownAnimation.setRepeatMode(android.view.animation.Animation.REVERSE);


    TranslateAnimation diagonalAnimation1 = new TranslateAnimation(
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 3.7f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, -3.7f);
        diagonalAnimation1.setDuration(2000);
        diagonalAnimation1.setRepeatCount(android.view.animation.Animation.INFINITE);
        diagonalAnimation1.setRepeatMode(android.view.animation.Animation.REVERSE);

    TranslateAnimation diagonalAnimation2 = new TranslateAnimation(
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, -3.7f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, -3.7f);
        diagonalAnimation2.setDuration(2000);
        diagonalAnimation2.setRepeatCount(android.view.animation.Animation.INFINITE);
        diagonalAnimation2.setRepeatMode(android.view.animation.Animation.REVERSE);

    TranslateAnimation upAnimation = new TranslateAnimation(
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, -3.7f
    );
        upAnimation.setDuration(3000);

    TranslateAnimation rightAnimation = new TranslateAnimation(
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 3.7f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f
    );
        rightAnimation.setDuration(3000);

    TranslateAnimation downAnimation = new TranslateAnimation(
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 3.7f
    );
        downAnimation.setDuratioт(3000);

    TranslateAnimation leftAnimation = new TranslateAnimation(
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, -3.7f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f,
            android.view.animation.Animation.RELATIVE_TO_SELF, 0f
    );
        leftAnimation.setDuration(3000);

    AnimationSet animationSquare = new AnimationSet(true);
        animationSquare.addAnimation(upAnimation);
        animationSquare.addAnimation(rightAnimation);
        animationSquare.addAnimation(downAnimation);
        animationSquare.addAnimation(leftAnimation);
}
