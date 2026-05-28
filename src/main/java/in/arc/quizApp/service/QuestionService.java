package in.arc.quizApp.service;

import in.arc.quizApp.entity.Question;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class QuestionService {

    public Question saveQuestion(Question question) {
        return null;
    }
}
