package org.skypro.ExaminerService.domain;

import java.util.Objects;

public class Question {

    private final String questionDescription;
    private final String questionAnswer;

    public Question(String question, String questionAnswer) {
        this.questionDescription = question;
        this.questionAnswer = questionAnswer;
    }

    public String getQuestion() {
        return this.questionDescription;
    }

    public String getAnswer() {
        return this.questionAnswer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question question)) return false;
        return Objects.equals(questionDescription, question.questionDescription) && Objects.equals(questionAnswer, question.questionAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionDescription, questionAnswer);
    }

}
