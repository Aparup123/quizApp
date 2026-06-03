package in.arc.quizApp.service;

import in.arc.quizApp.entity.Quiz;
import in.arc.quizApp.exceptions.ApiError;
import in.arc.quizApp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QuizService {
    @Autowired private QuizRepository quizRepository;

    public Quiz saveQuiz(Quiz quiz){
        return quizRepository.save(quiz);
    }

    public Quiz getQuizById(UUID id) {
        return quizRepository.findById(id).orElseThrow(()-> new ApiError(404, "Quiz not found."));
    }
}
