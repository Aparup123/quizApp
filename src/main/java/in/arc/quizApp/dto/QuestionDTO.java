package in.arc.quizApp.dto;


import in.arc.quizApp.entity.Option;
import in.arc.quizApp.entity.QuestionType;
import lombok.Data;
import lombok.ToString;
import java.util.List;
import java.util.UUID;

@Data
@ToString
public class QuestionDTO {
    private UUID id;
    private String content;
    private QuestionType type;
    private List<String> tags;
    private List<Option> options;
}
