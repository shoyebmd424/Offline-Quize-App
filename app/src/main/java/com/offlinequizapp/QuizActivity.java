package com.offlinequizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {
    private TextView questions,timer;
    private  TextView question;
    private AppCompatButton options1,option2,option3,option4;
    private AppCompatButton nextBtn;
    private Timer quizeTimer;
    private  int totaltimemins=1;
    private int seconds=0;
    private  List<QuestionsList> questionsLists;
    private int curquestionpos=0;
    private String curSelectedByUser="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        final ImageView backBtn=findViewById(R.id.back_btn);
        final  TextView selectedTopic=findViewById(R.id.topic);
        questions =findViewById(R.id.questionNum);
        question=findViewById(R.id.question);
        options1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        nextBtn=findViewById(R.id.next_btn);
        timer=findViewById(R.id.timer);

        final  String getSelectedTopic=getIntent().getStringExtra("selectedTopic");
        selectedTopic.setText(getSelectedTopic);


questionsLists=QuestionBank.getQuestions(getSelectedTopic);
        startTimer(timer);

        questions.setText((curquestionpos+1)+"/"+questionsLists.size());
        question.setText(questionsLists.get(0).getQuestion());
        options1.setText(questionsLists.get(0).getOption1());
        option2.setText(questionsLists.get(0).getOption2());
        option3.setText(questionsLists.get(0).getOption3());
        option4.setText(questionsLists.get(0).getOption4());
options1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(curSelectedByUser.isEmpty()){
            curSelectedByUser=options1.getText().toString();
            options1.setBackgroundResource(R.drawable.round_back_red10);
            options1.setTextColor(Color.WHITE);
            revealAns();
            questionsLists.get(curquestionpos).setUseSelectAns(curSelectedByUser);
        }

    }
});option2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(curSelectedByUser.isEmpty()){
            curSelectedByUser=option2.getText().toString();
            option2.setBackgroundResource(R.drawable.round_back_red10);
            option2.setTextColor(Color.WHITE);
            revealAns();
            questionsLists.get(curquestionpos).setUseSelectAns(curSelectedByUser);
        }
    }
});option3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(curSelectedByUser.isEmpty()){
            curSelectedByUser=option3.getText().toString();
            option3.setBackgroundResource(R.drawable.round_back_red10);
            option3.setTextColor(Color.WHITE);
            revealAns();
            questionsLists.get(curquestionpos).setUseSelectAns(curSelectedByUser);
        }
    }
});option4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(curSelectedByUser.isEmpty()){
            curSelectedByUser=option4.getText().toString();
            option4.setBackgroundResource(R.drawable.round_back_red10);
            option4.setTextColor(Color.WHITE);
            revealAns();
            questionsLists.get(curquestionpos).setUseSelectAns(curSelectedByUser);
        }
    }
});nextBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
            if(curSelectedByUser.isEmpty()){
                Toast.makeText(QuizActivity.this, "Please any one option", Toast.LENGTH_SHORT).show();
            }else{
        changeNextQuestion();
            }
    }
});


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizeTimer.purge();
                quizeTimer.cancel();
                startActivity(new Intent(QuizActivity.this,MainActivity.class));
                finish();
            }
        });


    }
    private void changeNextQuestion(){
        curquestionpos++;
        if(curquestionpos+1==questionsLists.size()){
            nextBtn.setText("Submit Quiz");
        }
        if(curquestionpos<questionsLists.size()){
            curSelectedByUser="";
            options1.setBackgroundResource(R.drawable.round_back_white10);
            options1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white10);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white10);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white10);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((curquestionpos+1)+"/"+questionsLists.size());
            question.setText(questionsLists.get(curquestionpos).getQuestion());
            options1.setText(questionsLists.get(curquestionpos).getOption1());
            option2.setText(questionsLists.get(curquestionpos).getOption2());
            option3.setText(questionsLists.get(curquestionpos).getOption3());
            option4.setText(questionsLists.get(curquestionpos).getOption4());
        }else{
            Intent intent=new Intent(QuizActivity.this,QuizResult.class);
            intent.putExtra("correct",getCorrectAns());
            intent.putExtra("incorrect",getInCorrectAns());
            startActivity(intent);
            finish();
        }
    }
    private  void startTimer(TextView view){
        quizeTimer=new Timer();
      quizeTimer.scheduleAtFixedRate(new TimerTask() {
          @Override
          public void run() {
              if(seconds==0) {
                  totaltimemins--;
                  seconds = 59;
              }
              else  if(seconds==0&&totaltimemins==0){
                  quizeTimer.purge();
                  quizeTimer.cancel();
                  Toast.makeText(QuizActivity.this, "Time Over", Toast.LENGTH_SHORT).show();
                  Intent intent=new Intent(QuizActivity.this,QuizResult.class);
                  intent.putExtra("correct" ,getCorrectAns());
                  intent.putExtra("incorrect",getInCorrectAns());
                  startActivity(intent);
                  finish();}
            else{
                  seconds--;
              }
              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                       String finalMinusts=String.valueOf(totaltimemins);
                       String finalSeconds=String.valueOf(seconds);
                      if(finalMinusts.length()==1){
                          finalMinusts="0"+finalMinusts;
                      }
                      if(finalSeconds.length()==1){
                          finalSeconds="0"+finalSeconds;
                      }
                      view.setText(finalMinusts+":"+finalSeconds);
                  }
              });
          }
      },1000,1000);
    }
    private  int getCorrectAns(){
    int correct=0;
    for(int i=0;i<questionsLists.size();i++){
        final String getUserSelectAns=questionsLists.get(i).getUseSelectAns();
        final String getAns=questionsLists.get(i).getAnswer();
        if(getUserSelectAns.equals(getAns)){
            correct++;
        }
    }
    return correct;
    }
    private  int getInCorrectAns(){
    int Incorrect=0;
    for(int i=0;i<questionsLists.size();i++){
        final String getUserSelectAns=questionsLists.get(i).getUseSelectAns();
        final String getAns=questionsLists.get(i).getAnswer();
        if(!getUserSelectAns.equals(getAns)){
            Incorrect++;
        }
    }
    return Incorrect;
    }

    @Override
    public void onBackPressed() {
     quizeTimer.purge();
     quizeTimer.cancel();
     startActivity(new Intent(QuizActivity.this,MainActivity.class));
     finish();
    }
    private void revealAns() {
        final String getAns = questionsLists.get(curquestionpos).getAnswer();
        if (options1.getText().toString().equals(getAns)) {
            options1.setBackgroundResource(R.drawable.round_back_green10);
            options1.setTextColor(Color.WHITE);
        } else if (option2.getText().toString().equals(getAns)) {
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        } else if (option2.getText().toString().equals(getAns)) {
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        } else if (option3.getText().toString().equals(getAns)) {
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        } else {
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }
}