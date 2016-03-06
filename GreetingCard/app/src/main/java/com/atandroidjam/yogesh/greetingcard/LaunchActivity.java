package com.atandroidjam.yogesh.greetingcard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class LaunchActivity extends Activity {

    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        //View.OnTouchListener = new View.OnTouchListener();

        View imageView = findViewById(R.id.background_imageview);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {

                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getAxisValue(MotionEvent.AXIS_X);
                        return true;

                    case MotionEvent.ACTION_UP:
                        x2 = event.getAxisValue(MotionEvent.AXIS_X);
                        float deltaX = x2 - x1;
                        if (Math.abs(deltaX) > MIN_DISTANCE) {
                            if (x1 > x2) {
                                Intent slideactivity = new Intent(LaunchActivity.this, SecondActivity.class);
                                startActivity(slideactivity);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                return true;
                            }
                        }
                }
                return false;
            }
        });

    }
}
