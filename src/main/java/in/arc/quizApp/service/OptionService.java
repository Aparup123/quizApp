package in.arc.quizApp.service;

import in.arc.quizApp.entity.Option;
import in.arc.quizApp.entity.Question;
import in.arc.quizApp.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public List<Option> saveOptions(Question question) {
        List<Option> options = question.getOptions();
        options.forEach(o->o.setQuestion(question));
        return optionRepository.saveAll(options);
    }
}
