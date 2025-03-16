package org.skypro.ExaminerService.service;

import org.skypro.ExaminerService.domain.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question addQuestion(String questionText, String answer) {
        Question newQuest = new Question(questionText, answer);
        questions.add(newQuest);
        return newQuest;
    }

    @Override
    public Question removeQuestion(String questionText, String answer) {
        Question questionToRemove = null;
        for (Question question : questions) {
            if (Objects.equals(question.getQuestion(), questionText) && Objects.equals(question.getAnswer(), answer)) {
                questionToRemove = question;
                break;
            }
        }
        questions.remove(questionToRemove);
        return questionToRemove;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(questions.size());
        Iterator<Question> iterator = questions.iterator();
        Question currQuestion = null;
        int i = 0;
        while (iterator.hasNext()) {
            Question question = iterator.next();
            if (i == randomIndex) {
                currQuestion = question;
                break;
            }
            i++;
        }
        return currQuestion;
    }

}