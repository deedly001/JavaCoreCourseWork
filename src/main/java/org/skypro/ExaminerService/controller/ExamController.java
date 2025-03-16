package org.skypro.ExaminerService.controller;

import org.skypro.ExaminerService.domain.Question;
import org.skypro.ExaminerService.service.ExaminerServicelmpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerServicelmpl examineServicelmpl;

    public ExamController(ExaminerServicelmpl examineServicelmpl) {
        this.examineServicelmpl = examineServicelmpl;
    }

    @GetMapping("exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examineServicelmpl.getQuestions(amount);
    }
}
