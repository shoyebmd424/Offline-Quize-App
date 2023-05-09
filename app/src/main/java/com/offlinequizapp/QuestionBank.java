package com.offlinequizapp;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    static List<QuestionsList> javaQuestions(){
        List<QuestionsList> questions=new ArrayList<>();
        questions.add(new QuestionsList("what is int size in java","8bit","16bit","32bit","64bit","32bit",""));
        questions.add(new QuestionsList("what is main pilar of java","oops","threading","sync","programming","oops",""));
        questions.add(new QuestionsList("which is keyword of java","static","variable","oops","constructor","static",""));
        questions.add(new QuestionsList("which is access modifier","variable","static","void","public","public",""));
   return questions;
    }static List<QuestionsList> jsQuestions(){
        List<QuestionsList> questions=new ArrayList<>();
        questions.add(new QuestionsList("what is int size in java","8bit","16bit","32bit","64bit","32bit",""));
        questions.add(new QuestionsList("what is main pilar of java","oops","threading","sync","programming","oops",""));
        questions.add(new QuestionsList("which is keyword of java","static","variable","oops","constructor","static",""));
        questions.add(new QuestionsList("which is access modifier","variable","static","void","public","public",""));
   return questions;
    }static List<QuestionsList> reactQuestions(){
        List<QuestionsList> questions=new ArrayList<>();
        questions.add(new QuestionsList("what is int size in java","8bit","16bit","32bit","64bit","32bit",""));
        questions.add(new QuestionsList("what is main pilar of java","oops","threading","sync","programming","oops",""));
        questions.add(new QuestionsList("which is keyword of java","static","variable","oops","constructor","static",""));
        questions.add(new QuestionsList("which is access modifier","variable","static","void","public","public",""));
   return questions;
    }static List<QuestionsList> androidQuestions(){
        List<QuestionsList> questions=new ArrayList<>();
        questions.add(new QuestionsList("what is int size in java","8bit","16bit","32bit","64bit","32bit",""));
        questions.add(new QuestionsList("what is main pilar of java","oops","threading","sync","programming","oops",""));
        questions.add(new QuestionsList("which is keyword of java","static","variable","oops","constructor","static",""));
        questions.add(new QuestionsList("which is access modifier","variable","static","void","public","public",""));
   return questions;
    }
    public  static  List<QuestionsList> getQuestions(String topic){
        switch (topic){
            case "java":
                return javaQuestions();
            case "js":
                    return jsQuestions();
            case "react":
                    return reactQuestions();
            default:
                    return androidQuestions();
        }
    }
}
