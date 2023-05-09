package com.offlinequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private  String selectedTopic="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout java=findViewById(R.id.java_topic);
        final LinearLayout js=findViewById(R.id.js_topic);
        final LinearLayout react=findViewById(R.id.react_topic);
        final LinearLayout android=findViewById(R.id.android_topic);
        final Button start_btn=findViewById(R.id.start_btn);
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="java";
                java.setBackgroundResource(R.drawable.round_bg_white);
                js.setBackgroundResource(R.drawable.round_back_white10);
                react.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);
            }
        });
        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="js";
                js.setBackgroundResource(R.drawable.round_bg_white);
                java.setBackgroundResource(R.drawable.round_back_white10);
                react.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);
            }
        });
        react.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="react";
                react.setBackgroundResource(R.drawable.round_bg_white);
                java.setBackgroundResource(R.drawable.round_back_white10);
                js.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);
            }
        });
        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="android";
                android.setBackgroundResource(R.drawable.round_bg_white);
                java.setBackgroundResource(R.drawable.round_back_white10);
                js.setBackgroundResource(R.drawable.round_back_white10);
                react.setBackgroundResource(R.drawable.round_back_white10);
            }
        });
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(selectedTopic.isEmpty()){
                   Toast.makeText(MainActivity.this, "Please select the topic", Toast.LENGTH_SHORT).show();
               }else {
                   Intent intent=new Intent(MainActivity.this,QuizActivity.class);
                   intent.putExtra("selectedTopic",selectedTopic);
                   startActivity(intent);
               }
            }
        });

    }
}