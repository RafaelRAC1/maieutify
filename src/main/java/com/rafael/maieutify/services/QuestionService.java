package com.rafael.maieutify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.Question;
import com.rafael.maieutify.repository.QuestionRepository;

@Service
public class QuestionService{
    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Iterable<Question> createQuestions(Iterable<Question> questions){
        return questionRepository.saveAll(questions);
    }
}
