package com.example.myapplication7;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = new Fragment();
        getFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }
}
