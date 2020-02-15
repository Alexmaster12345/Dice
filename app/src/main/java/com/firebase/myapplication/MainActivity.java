package com.firebase.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.*;
import android.view.View;
import java.util.Random;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    TextView winner;
    ImageView leftCube,rightCube;
    Button buttonReset;
    ArrayList<Integer> arrRight,arrLeft;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonReset =  findViewById(R.id.resetCube);
        rightCube = (ImageView) findViewById(R.id.cubeRight);
        leftCube = (ImageView) findViewById(R.id.cubeLeft);
        winner = (TextView) findViewById(R.id.textWin);


        arrRight = new ArrayList<Integer>();
        arrRight.add(R.drawable.one);
        arrRight.add(R.drawable.two);
        arrRight.add(R.drawable.tree);
        arrRight.add(R.drawable.four);
        arrRight.add(R.drawable.five);
        arrRight.add(R.drawable.six);

        arrLeft = new ArrayList<Integer>();
        arrLeft.add(R.drawable.one);
        arrLeft.add(R.drawable.two);
        arrLeft.add(R.drawable.tree);
        arrLeft.add(R.drawable.four);
        arrLeft.add(R.drawable.five);
        arrLeft.add(R.drawable.six);

        random = new Random();

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arrtemp1 = arrRight.get(random.nextInt(6));
                rightCube.setImageResource(arrtemp1);
                int arrtemp2 = arrLeft.get(random.nextInt(6));
                leftCube.setImageResource(arrtemp2);


                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50); //You can manage the blinking time with this parameter
                anim.setStartOffset(500);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);

                if(arrtemp1 == arrtemp2) {
                    winner.setText("Winner");
                    winner.startAnimation(anim);
                    winner.setTextColor(Color.parseColor("#f24646"));
                }
                else {
                    winner.setText("Try again");
                    winner.clearAnimation();
                    winner.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

    }


}
