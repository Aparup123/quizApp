package in.arc.quizApp.mapper;

import in.arc.quizApp.dto.QuizQuestionDTO;
import in.arc.quizApp.entity.QuizQuestion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class QuizQuestionMapper {
    public QuizQuestion toEntity(QuizQuestionDTO quizQuestionDTO){
        QuizQuestion quizQuestion = new QuizQuestion();
        BeanUtils.copyProperties(quizQuestionDTO, quizQuestion);
        return quizQuestion;
    }

    public QuizQuestionDTO toDTO(QuizQuestion quizQuestion){
        QuizQuestionDTO quizQuestionDTO = new QuizQuestionDTO();
        BeanUtils.copyProperties(quizQuestion, quizQuestionDTO);
        quizQuestionDTO.setQuestionId(quizQuestion.getQuestion().getId());
        return quizQuestionDTO;
    }
}
