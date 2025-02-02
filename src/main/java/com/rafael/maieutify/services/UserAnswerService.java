package com.rafael.maieutify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.UserAnswer;
import com.rafael.maieutify.repository.UserAnswerRepository;

@Service
public class UserAnswerService {
    @Autowired
    private UserAnswerRepository userAnswerRepository;

    public UserAnswer createUserAnswer(UserAnswer userAnswer) {
        return this.userAnswerRepository.save(userAnswer);
    }

    public UserAnswer getUserAnswerById(Long id) {
        return this.userAnswerRepository.findById(id).orElse(null);
    }

    public Iterable<UserAnswer> createUserAnswers(Iterable<UserAnswer> userAnswers){
        return this.userAnswerRepository.saveAll(userAnswers);
    }
}
