package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exercise.kakao.MapViewActivity;
import com.example.exercise.ui.MapActivity;


public class GestureActivity extends AppCompatActivity implements OnGestureListener  {

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    private GestureDetector gestureScanner;
    public String userNick;
    public String userType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        userNick=intent.getExtras().getString("nickname");
        userType=intent.getExtras().getString("type");


        gestureScanner = new GestureDetector(this);
        setContentView(R.layout.activity_gesture);
    }
    public void btnback (View v){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void btn_replay (View v){
        Intent intent = new Intent(getApplicationContext(),PageReplay.class);
        startActivity(intent);
    }
    public void btn_guide (View v){
        Intent intent = new Intent(getApplicationContext(),PageGuide.class);
        startActivity(intent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return gestureScanner.onTouchEvent(me);
    }
    public boolean onDown(MotionEvent e) {

        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                return false;

            // right to left swipe
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Toast.makeText(getApplicationContext(), "Left Swipe", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);


                startActivity(intent);
            }
            // left to right swipe
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Toast.makeText(getApplicationContext(), "Right Swipe", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ChatActivity.class);
                intent.putExtra("nickname",userNick);
                intent.putExtra("type",userType);
                startActivity(intent);
            }

        } catch (Exception e) {

        }
        return true;
    }


}