package com.example.projectt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

public class test extends AppCompatActivity implements View.OnTouchListener{
    private ViewFlipper vFlipper;
    private float xAtDown;
    private float xAtUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        setUpUI();
    }

    private void setUpUI() {
        vFlipper = (ViewFlipper)findViewById(R.id.flipper);
        vFlipper.setOnTouchListener(this);

    }


    private void nextFlipper(){
        vFlipper.showNext();
    }
    private void prevFlipper() {
        vFlipper.showPrevious();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (v != vFlipper)
            return false;

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            xAtDown = event.getX(); // 터치 시작지점 x좌표 저장

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            xAtUp = event.getX(); // 터치 끝난지점 x좌표 저장

            if (xAtUp < xAtDown) {
                nextFlipper();
            } else if (xAtUp > xAtDown) {
                prevFlipper();
            }
        }
        return true;
    }
}
