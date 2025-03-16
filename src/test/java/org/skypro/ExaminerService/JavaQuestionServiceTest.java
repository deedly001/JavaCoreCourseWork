package org.skypro.ExaminerService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.ExaminerService.domain.Question;
import org.skypro.ExaminerService.service.JavaQuestionService;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void if_QuestionServiceEmpty() {
        assertTrue(javaQuestionService.getAll().isEmpty());
    }

    @Test
    void add_Question() {
        Question question = new Question("true or false", "true");
        javaQuestionService.addQuestion(question.getQuestion(), question.getAnswer());
        Assertions.assertTrue(javaQuestionService.getAll().contains(question));
    }

    @Test
    void remove_Question() {
        Question question = new Question("true or false", "true");
        javaQuestionService.addQuestion(question.getQuestion(), question.getAnswer());
        Question removedQuestion = javaQuestionService.removeQuestion(question.getQuestion(), question.getAnswer());
        Assertions.assertEquals(question, removedQuestion);
        Assertions.assertFalse(javaQuestionService.getAll().contains(question));
    }


    @Test
    void get_RandomQuestion() {
        javaQuestionService.addQuestion("Cat`s hates ", "dogs");
        javaQuestionService.addQuestion("dog`s hates ", "cats");
        Question randomQuestion = javaQuestionService.getRandomQuestion();
        Assertions.assertTrue(javaQuestionService.getAll().contains(randomQuestion));
    }

}