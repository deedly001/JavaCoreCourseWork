package org.skypro.ExaminerService.service;

import org.skypro.ExaminerService.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}