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
import com.rafael.maieutify.service.AlternativeService;
import com.rafael.maieutify.service.ListQuestionsUserService;
import com.rafael.maieutify.service.QuestionService;
import com.rafael.maieutify.service.UserAnswerService;

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

    @PostMapping("/addAll/list-user/{list_user_id}")
    public ResponseEntity<Object> createUserAnswers(@PathVariable(value = "list_user_id") Long listUserId,
            @RequestBody Iterable<UserAnswer> userAnswers) {
        ListQuestionsUser listQuestionsUser = this.listQuestionsUserService.getListQuestionUserById(listUserId);
        if (listQuestionsUser == null) {
            return new ResponseEntity<>("User answer was not created", HttpStatus.NOT_FOUND);
        }
        for(UserAnswer userAnswer : userAnswers) {
            Question question = this.questionService.getQuestionById(userAnswer.getQuestion().getId());
            Alternative alternative = this.alternativeService.getAlternativeById(userAnswer.getAlternative().getId());
            if(question == null || alternative == null) {
                return new ResponseEntity<>("User answer was not created", HttpStatus.NOT_FOUND);
            }
            userAnswer.setAlternative(alternative);
            userAnswer.setQuestion(question);
            userAnswer.setListQuestionsUser(listQuestionsUser);
        }
        this.userAnswerService.createUserAnswers(userAnswers);
        return new ResponseEntity<>("User answers registered successfully", HttpStatus.CREATED);
    }
}
