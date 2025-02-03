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
import com.rafael.maieutify.model.entity.Question;
import com.rafael.maieutify.service.AlternativeService;
import com.rafael.maieutify.service.QuestionService;

@RestController
@RequestMapping("alternative")
public class AlternativeController {
    @Autowired
    private AlternativeService alternativeService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add/{question_id}")
    public ResponseEntity<Object> createAlternative(@PathVariable(value = "question_id") Long questionId, @RequestBody Alternative alternative) {
        try {
            Question question = questionService.getQuestionById(questionId);
            if (question == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
            }
    
            alternative.setQuestion(question);
            Alternative createdAlternative = alternativeService.createAlternative(alternative);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the alternative");
        }
    }
 
    @PostMapping("/addAll/{question_id}")
    public ResponseEntity<Object> createAlternatives(@PathVariable(value = "question_id") Long questionId, @RequestBody Iterable<Alternative> alternatives){
        Question question = questionService.getQuestionById(questionId);
         if(question == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        alternatives.forEach((alternative) -> {
            alternative.setQuestion(question);
        });
        alternativeService.createAlternatives(alternatives);
        return new ResponseEntity<>("Alternatives created successfully", HttpStatus.CREATED);
    }
}
