package com.offlinequizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        final AppCompatButton restart_btn=findViewById(R.id.restart);
        final TextView correct=findViewById(R.id.correct);
        final TextView incorrect=findViewById(R.id.incorrect);
        final String correctAns="Correct answer : "+getIntent().getIntExtra("correct",0);
        final String incorrectAns="Incorrect answer :"+ getIntent().getIntExtra("incorrect",0);
        correct.setText(correctAns);
        incorrect.setText(incorrectAns);

        restart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResult.this,MainActivity.class));
                finish();
            }
        });



    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResult.this,MainActivity.class));
        finish();
    }
}