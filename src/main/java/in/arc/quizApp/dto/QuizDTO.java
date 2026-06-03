package in.arc.quizApp.dto;

import in.arc.quizApp.entity.QuizType;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class QuizDTO {
    private UUID id;
    private String topic;
    private String description;
    private QuizType quizType;
    private double durationInMinutes;
    private double totalPoints;
    List<QuizQuestionDTO> quizQuestionDTOs;
}
