package org.skypro.ExaminerService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.ExaminerService.domain.Question;
import org.skypro.ExaminerService.service.ExaminerServicelmpl;
import org.skypro.ExaminerService.service.JavaQuestionService;
import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceTestMock;

    @InjectMocks
    private ExaminerServicelmpl examinerServiceTest;

    @Test
    public void getQuestions() {
        int amount = 1;
        Question question = new Question("attack?", "defend!");
        List<Question> result =
                new ArrayList<>(List.of(new Question("attack?", "defend!")));
        when(javaQuestionServiceTestMock.getRandomQuestion()).thenReturn(question);
        when(javaQuestionServiceTestMock.getAll()).thenReturn(result);
        List<Question> expectedResults = (List<Question>) examinerServiceTest.getQuestions(amount);
        assertEquals(question, expectedResults.get(0));
    }

    @Test
    public void getWrongAmount() {
        when(javaQuestionServiceTestMock.getAll()).thenReturn(emptyList());
        assertThrows(RuntimeException.class, () -> {
            examinerServiceTest.getQuestions(1);
        });
    }

}

