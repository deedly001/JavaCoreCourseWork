package org.skypro.ExaminerService.service;
import org.springframework.stereotype.Service;
import org.skypro.ExaminerService.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ExaminerServicelmpl implements ExaminerService {
    QuestionService questionService;

    public ExaminerServicelmpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new IllegalArgumentException("В хранилище нет такого количества вопросов. Повторите ввод.");
        }
        Set<Question> selectedQuestions = new HashSet<>();
        while (selectedQuestions.size() < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            selectedQuestions.add(randomQuestion);
        }
        return selectedQuestions.stream().toList();
    }
}

