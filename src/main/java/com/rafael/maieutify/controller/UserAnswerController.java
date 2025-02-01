package com.rafael.maieutify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.maieutify.model.entity.Alternative;
import com.rafael.maieutify.model.entity.ListQuestionsUser;
import com.rafael.maieutify.model.entity.Question;
import com.rafael.maieutify.model.entity.UserAnswer;
import com.rafael.maieutify.services.AlternativeService;
import com.rafael.maieutify.services.ListQuestionsUserService;
import com.rafael.maieutify.services.QuestionService;
import com.rafael.maieutify.services.UserAnswerService;

@RestController
@RequestMapping("/user-answer")
public class UserAnswerController {
    @Autowired
    private UserAnswerService userAnswerService;

    @Autowired
    private ListQuestionsUserService listQuestionsUserService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AlternativeService alternativeService;

    @PostMapping("/add/list-user/{list_user_id}")
    public ResponseEntity<Object> createUserAnswer(@PathVariable(value = "list_user_id") Long listUserId,
            @RequestBody UserAnswer userAnswer) {
        ListQuestionsUser listQuestionsUser = this.listQuestionsUserService.getListQuestionUserById(listUserId);
        Question question = this.questionService.getQuestionById(userAnswer.getQuestion().getId());
        Alternative alternative = this.alternativeService.getAlternativeById(userAnswer.getAlternative().getId());
        if (listQuestionsUser == null || alternative == null || question == null) {
            return new ResponseEntity<>("User answer was not created", HttpStatus.NOT_FOUND);
        }
        userAnswer.setListQuestionsUser(listQuestionsUser);
        userAnswer.setQuestion(question);
        userAnswer.setAlternative(alternative);
        this.userAnswerService.createUserAnswer(userAnswer);
        return new ResponseEntity<>("User answer registered successfully", HttpStatus.CREATED);
    }
}
