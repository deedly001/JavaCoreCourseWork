package org.skypro.ExaminerService.service;
import org.skypro.ExaminerService.domain.Question;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public interface QuestionService {
    Question addQuestion(String question, String answer);
    Question removeQuestion(String questionText,String answer);
    Question getRandomQuestion();
    Collection<Question> getAll();
}
