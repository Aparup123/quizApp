package in.arc.quizApp.controller;

import in.arc.quizApp.dto.QuestionDTO;
import in.arc.quizApp.entity.Question;
import in.arc.quizApp.mapper.QuestionMapper;
import in.arc.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public QuestionDTO saveQuestion(@RequestBody QuestionDTO questionDTO){
        Question question = questionMapper.toEntity(questionDTO);
        Question savedQuestion = questionService.saveQuestion(question);
        return questionMapper.toDTO(savedQuestion);
    }

}
