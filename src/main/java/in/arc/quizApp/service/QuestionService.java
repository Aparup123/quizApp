package in.arc.quizApp.service;

import in.arc.quizApp.entity.Question;
import in.arc.quizApp.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
}
