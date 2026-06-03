package in.arc.quizApp.mapper;

import in.arc.quizApp.dto.QuizDTO;
import in.arc.quizApp.entity.Quiz;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {
    @Autowired
    private QuizQuestionMapper quizQuestionMapper;
    public Quiz toEntity(QuizDTO quizDTO){
        Quiz quiz = new Quiz();
        BeanUtils.copyProperties(quizDTO, quiz);
        return quiz;
    }

    public QuizDTO toDTO(Quiz quiz){
        QuizDTO quizDTO = new QuizDTO();
        BeanUtils.copyProperties(quiz, quizDTO);
        quizDTO.setQuizQuestionDTOs(
                quiz.getQuizQuestions().stream().map(quizQuestion -> quizQuestionMapper.toDTO(quizQuestion)).toList()
        );
        return quizDTO;
    }
}
