package in.arc.quizApp.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class QuizQuestionDTO {
    private int order;
    private UUID questionId;
    private double point;
}
