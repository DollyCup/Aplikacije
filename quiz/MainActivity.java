package com.example.myapplication;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {



                //set controls
                TextView tvQueCounter, tvTimer, tvQue;

                Button btOpt1, btOpt2, btOpt3, btOpt4;

                //list for que
                ArrayList<QuestionClass> queList = new ArrayList<>();

                int counter = 0;

                CountDownTimer tm;

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);


                        //find view by ids
                        tvQue = findViewById(R.id.tvQue);
                        tvQueCounter = findViewById(R.id.tvQueConter);
                        tvTimer = findViewById(R.id.tvTimer);

                        btOpt1 = findViewById(R.id.btOpt1);
                        btOpt2 = findViewById(R.id.btOpt2);
                        btOpt3 = findViewById(R.id.btOpt3);
                        btOpt4 = findViewById(R.id.btOpt4);

                        //load data

                        queList.add(new QuestionClass("Glavni grad Hrvatske", "Zagreb", "Rijeka",
                                "Split", "Delnice", "Zagreb"));
                        queList.add(new QuestionClass("Najduža rijeka u Hrvatskoj", "Rječina", "Sava",
                                "Drava", "Dunav", "Sava"));
                        queList.add(new QuestionClass("Najviša planina u Hrvatskoj", "Tuhobić", "Učka",
                                "Velebit", "Papuk", "Velebit"));


                        tm = new CountDownTimer(12 * 1000, 1000) {


                                @Override
                                public void onTick(long millisUntilFinished) {
                                        tvTimer.setText("" + millisUntilFinished / 1000);
                                }

                                @Override
                                public void onFinish() {

                                        Toast.makeText(MainActivity.this, "Quiz Over", Toast.LENGTH_SHORT).show();
                                }
                        };

                        loadQuetions(counter);
                }

                public void loadQuetions(int n) {

                        final QuestionClass q = queList.get(n);

                        tvQueCounter.setText((n + 1) + "/" + queList.size());

                        tvTimer.setText("" + 12);
                        if (tm != null) {
                                tm.start();
                        }

                        tvQue.setText("#" + (n + 1) + " " + q.getQue());
                        btOpt1.setText("" + q.getOpt1());
                        btOpt2.setText("" + q.getOpt2());
                        btOpt3.setText("" + q.getOpt3());
                        btOpt4.setText("" + q.getOpt4());

                        btOpt1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                        if (btOpt1.getText().equals(q.getRightOpt())) {
                                                Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                                                if (counter < (queList.size() - 1)) {
                                                        tm.cancel();
                                                        counter++;
                                                        loadQuetions(counter);
                                                } else {
                                                        Toast.makeText(MainActivity.this, "All Que Completed!", Toast.LENGTH_SHORT).show();
                                                }


                                        } else {
                                                Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                                        }


                                }
                        });

                        //btn2
                        btOpt2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                        if (btOpt2.getText().equals(q.getRightOpt())) {

                                                Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                                                if (counter < (queList.size() - 1)) {
                                                        tm.cancel();
                                                        counter++;
                                                        loadQuetions(counter);
                                                } else {
                                                        Toast.makeText(MainActivity.this, "All Que Completed!", Toast.LENGTH_SHORT).show();
                                                }

                                        } else {
                                                Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                                        }

                                }
                        });

                        //btn 3
                        btOpt3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                        if (btOpt3.getText().equals(q.getRightOpt())) {

                                                Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                                if (counter < (queList.size() - 1)) {
                                                        tm.cancel();
                                                        counter++;
                                                        loadQuetions(counter);
                                                } else {
                                                        Toast.makeText(MainActivity.this, "All Que Completed!", Toast.LENGTH_SHORT).show();
                                                }

                                        } else {
                                                Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                                        }

                                }
                        });

                        //btn4
                        btOpt4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                        if (btOpt4.getText().equals(q.getRightOpt())) {

                                                Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                                if (counter < (queList.size() - 1)) {
                                                        tm.cancel();
                                                        counter++;
                                                        loadQuetions(counter);
                                                } else {
                                                        Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_SHORT).show();
                                                }

                                        } else {
                                                Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                                        }

                                }
                        });

                }
        }
