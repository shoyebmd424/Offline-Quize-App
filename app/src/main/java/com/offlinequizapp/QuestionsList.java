package com.offlinequizapp;

public class QuestionsList {
    private String question,option1, option2 ,option3,option4,Answer;
private String useSelectAns;

    public QuestionsList(String question, String option1, String option2, String option3, String option4, String answer, String useSelectAns) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        Answer = answer;
        this.useSelectAns = useSelectAns;

    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAnswer() {
        return Answer;
    }

    public String getUseSelectAns() {
        return useSelectAns;
    }

    public void setUseSelectAns(String useSelectAns) {
        this.useSelectAns = useSelectAns;
    }
}
