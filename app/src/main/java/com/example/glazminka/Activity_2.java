package com.example.glazminka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btnGoToActivity = (Button) findViewById(R.id.btnGoToActivity);
        View.OnClickListener oclBtnGoToActivity = new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent( Activity_2.this, MainActivity.class );
                startActivity(intent);
            }
        };
        btnGoToActivity.setOnClickListener(oclBtnGoToActivity);

    }
}