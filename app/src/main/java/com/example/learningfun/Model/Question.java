package com.example.learningfun.Model;

import java.util.List;

public class Question {
    private int number;
    private String content;
    private List<Answer> answerList;

    public Question() {
    }

    public Question(int number, String content, List<Answer> answerList) {
        this.number = number;
        this.content = content;
        this.answerList = answerList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
