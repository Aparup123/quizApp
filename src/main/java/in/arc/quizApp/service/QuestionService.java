package in.arc.quizApp.service;

import in.arc.quizApp.entity.Question;
import in.arc.quizApp.exceptions.ApiError;
import in.arc.quizApp.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question getQuestionById(UUID id){
        return questionRepository.findById(id).orElseThrow(()-> new ApiError(404, "Question not found."));
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
