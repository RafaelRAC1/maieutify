package com.rafael.maieutify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.maieutify.model.entity.AppUser;
import com.rafael.maieutify.model.entity.ListQuestions;
import com.rafael.maieutify.model.entity.ListQuestionsUser;
import com.rafael.maieutify.service.AlternativeService;
import com.rafael.maieutify.service.AppUserService;
import com.rafael.maieutify.service.ListQuestionsService;
import com.rafael.maieutify.service.ListQuestionsUserService;
import com.rafael.maieutify.service.QuestionService;

@RestController
@RequestMapping("/list-user")
public class ListQuestionUserController {
    @Autowired
    private ListQuestionsUserService listQuestionsUserService;

    @Autowired
    private AppUserService appUserService;

    @Autowired  
    private ListQuestionsService listQuestionsService;

    @Autowired  
    private AlternativeService alternativeService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add/list/{list_id}/user/{user_id}")
    public ResponseEntity<Object> createListQuestionsUser(@PathVariable(value = "list_id") long listId, @PathVariable(value = "user_id") long userId, @RequestBody ListQuestionsUser listQuestionsUser){
        AppUser appUser = appUserService.getUserById(userId);
        if(appUser == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ListQuestions listQuestions = listQuestionsService.getListQuestionsById(listId);
        if(listQuestions == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listQuestionsUser.getUserAnswer().forEach((userAnswer) -> {
            userAnswer.setListQuestionsUser(listQuestionsUser);
        });
        listQuestionsUser.setAppUser(appUser);
        listQuestionsUser.setListQuestions(listQuestions);
        listQuestionsUser.getUserAnswer().forEach((userAnswer) -> {
            userAnswer.setListQuestionsUser(listQuestionsUser);
            userAnswer.setAlternative(alternativeService.getAlternativeById(userAnswer.getAlternative().getId()));
            userAnswer.setQuestion(questionService.getQuestionById(userAnswer.getQuestion().getId()));
        });
        listQuestionsUserService.createListQuestionsUser(listQuestionsUser);
        return new ResponseEntity<>("User response registered successfully", HttpStatus.CREATED);
    }   
}
