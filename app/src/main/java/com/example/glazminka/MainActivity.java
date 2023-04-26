package com.example.glazminka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoToSecAct = (Button) findViewById(R.id.btnGoToSecAct);
        View.OnClickListener oclBtnGoToSecAct = new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this , Activity_2.class);
                startActivity(intent);
            }
        };
        Button btnInfoAct = (Button) findViewById(R.id.btnInfoAct);
        View.OnClickListener oclBtnInfoAct = new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this , Activity_3.class);
                startActivity(intent);
            }
        };
        btnInfoAct.setOnClickListener(oclBtnInfoAct);
        btnGoToSecAct.setOnClickListener(oclBtnGoToSecAct);
    }
}