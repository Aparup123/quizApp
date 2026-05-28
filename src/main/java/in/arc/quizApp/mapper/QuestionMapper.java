package in.arc.quizApp.mapper;

import in.arc.quizApp.dto.QuestionDTO;
import in.arc.quizApp.entity.Question;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class QuestionMapper {
    public QuestionDTO toDTO(Question question){
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        return questionDTO;
    }

    public Question toEntity(QuestionDTO questionDTO){
        Question question = new Question();
        BeanUtils.copyProperties(questionDTO, question);
        return question;
    }
}
