package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Page3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
    }
    public void btn_back2 (View v){
        Intent intent = new Intent(getApplicationContext(),page2.class);
        startActivity(intent);
    }
    public void btn_speak (View v){
        Intent intent = new Intent(getApplicationContext(),Speaktotext.class);
        startActivity(intent);
    }
    public void btn_go (View v){
        Intent intent = new Intent(getApplicationContext(),Page4.class);
        startActivity(intent);
    }
}
