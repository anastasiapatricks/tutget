package com.tutget.main.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question extends QnaPost {
    private List<String> answerIds;
    private String questionTitle;

    public Question() {
        super();
        answerIds = new ArrayList<>();
    }

    public Question(String questionTitle, String questionString, String userId, String userName, String acadLvl, String acadSubj) {
        super(questionString, userId, userName, acadLvl, acadSubj);
        this.answerIds = new ArrayList<>();
        this.questionTitle = questionTitle;
    }

    public void setAnswers(List<String> answers) {
        this.answerIds = answers;
    }

    public void addAnswer(String answerId) {
        answerIds.add(answerId);
    }

    public List<String> getAnswers() {
        return answerIds;
    }

    public void removeAnswerById(String answerId) {
        answerIds.remove(answerId);
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
}
