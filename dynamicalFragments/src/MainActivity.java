package com.example.myapplication6;

import android.os.Bundle;

import android.view.View;
import android.app.Fragment;
import android.widget.Button;
import android.widget.FrameLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    Button btn_frag1 =findViewById(R.id.btn_frag1);
        Button btn_frag2 = findViewById(R.id.btn_frag2);
        FrameLayout fL1= findViewById(R.id.fL1);
        btn_frag1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Fragment fragment1 = new fragment1();
                    getFragmentManager().beginTransaction().replace(R.id.fL1, fragment1 ).commit();
                }
            });
        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            Fragment fragment2 = new fragment2();
                    getFragmentManager().beginTransaction().replace(R.id.fL1, fragment2).commit();
                }

            });
        }
    }

