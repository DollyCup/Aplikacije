package com.example.myapplication11;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    Button blink, slide, rotate, zoom;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.lolxd);
        blink = findViewById(R.id.btn1);
        slide = findViewById(R.id.btn2);
        rotate = findViewById(R.id.btn3);
        zoom = findViewById(R.id.btn4);
        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Animation object= AnimationUtils.loadAnimation(
                        getApplicationContext(),
                        R.anim.blink);
                logo.startAnimation(object);
            }
        });
        slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Animation object= AnimationUtils.loadAnimation(
                        getApplicationContext(),
                        R.anim.slide);
                logo.startAnimation(object);
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Animation object= AnimationUtils.loadAnimation(
                        getApplicationContext(),
                        R.anim.rotate);
                logo.startAnimation(object);
            }
        });

        zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Animation object= AnimationUtils
                        .loadAnimation(
                                getApplicationContext(),
                                R.anim.zoom);
                logo.startAnimation(object);
            }
        });
    }
}
