package com.example.glazminka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Activity_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        ImageButton tuda = (ImageButton) findViewById(R.id.tuda);
        View.OnClickListener oclTuda = new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent( Activity_3.this, MainActivity.class );
                startActivity(intent);
            }
        };
        tuda.setOnClickListener(oclTuda);
    }
}