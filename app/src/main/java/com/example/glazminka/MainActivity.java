package com.example.glazminka;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView TimerTextView = findViewById(R.id.timer_text_view);
        Button btnGoToSecAct = (Button) findViewById(R.id.btnGoToSecAct);
        Button btnInfoAct = (Button) findViewById(R.id.btnInfoAct);


        View.OnClickListener oclBtnGoToSecAct = new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                startActivity(intent);
            }
        };

        btnGoToSecAct.setOnClickListener(oclBtnGoToSecAct);


        View.OnClickListener oclBtnInfoAct = new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_3.class);
                startActivity(intent);
            }
        };
        btnInfoAct.setOnClickListener(oclBtnInfoAct);


    }
}




