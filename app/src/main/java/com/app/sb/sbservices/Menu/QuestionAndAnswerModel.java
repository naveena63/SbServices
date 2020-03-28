package com.app.sb.sbservices.Menu;

public class QuestionAndAnswerModel {
    String question;
    String answer;

    public QuestionAndAnswerModel(String question, String answer) {
        this.question=question;
        this.answer=answer;
    }

    public QuestionAndAnswerModel() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
