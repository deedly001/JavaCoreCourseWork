package org.skypro.ExaminerService.controller;

import org.skypro.ExaminerService.domain.Question;
import org.skypro.ExaminerService.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String questionText, @RequestParam String answer) {
        questionService.addQuestion(questionText, answer);
        return "Вопрос добавлен";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String questionText, @RequestParam String answer) {
        questionService.removeQuestion(questionText, answer);
        return "Вопрос удалён";
    }

    @GetMapping(path = "/java")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
