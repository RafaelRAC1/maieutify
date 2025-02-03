package com.rafael.maieutify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.maieutify.model.entity.ListQuestions;
import com.rafael.maieutify.model.entity.Question;
import com.rafael.maieutify.service.ListQuestionsService;
import com.rafael.maieutify.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private ListQuestionsService listQuestionsService;

    @PostMapping("/add/{list_id}")
    public ResponseEntity<Object> createQuestion(@PathVariable(value = "list_id") Long listId, @RequestBody Question question){
        ListQuestions listQuestions = listQuestionsService.getListQuestionsById(listId);
        if(listQuestions == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        question.setListQuestions(listQuestions);
        question.getAlternative().forEach((alternative) -> {
            alternative.setQuestion(question);
        });
        questionService.createQuestion(question);
        return new ResponseEntity<>("Question created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/addAll/{list_id}")
    public ResponseEntity<Object> createQuestions(@PathVariable(value = "list_id") Long listId, @RequestBody Iterable<Question> questions){
        ListQuestions listQuestions = listQuestionsService.getListQuestionsById(listId);
        if(listQuestions == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        questions.forEach((question) -> {
            question.getAlternative().forEach((alternative) -> {
                alternative.setQuestion(question);
            });
            question.setListQuestions(listQuestions);
        });
        questionService.createQuestions(questions);
        return new ResponseEntity<>("Questions created successfully", HttpStatus.CREATED);
    } 
}
