package com.example.myapplication10;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    private Day current;
    private EditText[] predmet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        Button[] btn_dan = new Button[6];
        btn_dan[0] = findViewById(R.id.pon);
        btn_dan[1] = findViewById(R.id.uto);
        btn_dan[2] = findViewById(R.id.sri);
        btn_dan[3] = findViewById(R.id.cet);
        btn_dan[4] = findViewById(R.id.pet);
        btn_dan[5] = findViewById(R.id.sub);


        btn_dan[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appdata.lastclickedId = 0;
                Intent intent = new Intent(EditActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
        btn_dan[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appdata.lastclickedId = 1;
                Intent intent = new Intent(EditActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
        btn_dan[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appdata.lastclickedId = 2;
                Intent intent = new Intent(EditActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
        btn_dan[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appdata.lastclickedId = 3;
                Intent intent = new Intent(EditActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
        btn_dan[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appdata.lastclickedId = 4;
                Intent intent = new Intent(EditActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
        btn_dan[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appdata.lastclickedId = 5;
                Intent intent = new Intent(EditActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });


        Button btnExit = findViewById(R.id.back);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditActivity.this.finish();
            }
        });

    }
}
