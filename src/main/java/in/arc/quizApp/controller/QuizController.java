package in.arc.quizApp.controller;

import in.arc.quizApp.dto.QuizDTO;
import in.arc.quizApp.entity.Quiz;
import in.arc.quizApp.entity.QuizQuestion;
import in.arc.quizApp.mapper.QuizMapper;
import in.arc.quizApp.mapper.QuizQuestionMapper;
import in.arc.quizApp.service.QuestionService;
import in.arc.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @Autowired
    private QuizMapper quizMapper;

    @Autowired
    private QuizQuestionMapper quizQuestionMapper;

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public QuizDTO createQuiz(@RequestBody QuizDTO quizDTO){
        Quiz quiz = quizMapper.toEntity(quizDTO);
        List<QuizQuestion> quizQuestions = quizDTO.getQuizQuestionDTOs().stream().map((quizQuestionDTO)->{
                     QuizQuestion quizQuestion = quizQuestionMapper.toEntity(quizQuestionDTO);
                     quizQuestion.setQuestion(
                             questionService.getQuestionById(
                                     quizQuestionDTO.getQuestionId()
                             )
                     );
                     quizQuestion.setQuiz(quiz);
                     return quizQuestion;
                }).collect(Collectors.toList());
        quiz.setQuizQuestions(quizQuestions);
        Quiz saveQuiz = quizService.saveQuiz(quiz);
        return quizMapper.toDTO(saveQuiz);
    }

    @GetMapping("/{id}")
    public QuizDTO getQuizById(@PathVariable UUID id){
        return quizMapper.toDTO(quizService.getQuizById(id));
    }
}
