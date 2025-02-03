package com.rafael.maieutify.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.maieutify.mapper.ListQuestionsCommentMapper;
import com.rafael.maieutify.mapper.ListQuestionsMapper;
import com.rafael.maieutify.mapper.dto.list_questions.ListQuestionsDTO;
import com.rafael.maieutify.mapper.dto.list_questions.ListQuestionsWithQuestionsDTO;
import com.rafael.maieutify.mapper.dto.list_questions_comments.ListQuestionsCommentDTO;
import com.rafael.maieutify.model.entity.AppUser;
import com.rafael.maieutify.model.entity.Category;
import com.rafael.maieutify.model.entity.ListQuestions;
import com.rafael.maieutify.service.AppUserService;
import com.rafael.maieutify.service.CategoryService;
import com.rafael.maieutify.service.ListQuestionsService;

@RestController
@RequestMapping("list")
public class ListQuestionsController {
    @Autowired
    private ListQuestionsService listQuestionsService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ListQuestionsMapper listQuestionsMapper;

    @Autowired
    private ListQuestionsCommentMapper listQuestionsCommentMapper;

    @PostMapping("add/{category_id}/{user_id}")
    public ResponseEntity<Object> createListQuestions(@PathVariable(value = "category_id") long categoryId,
            @PathVariable(value = "user_id") long userId, @RequestBody ListQuestions listQuestions) {
        AppUser appUser = appUserService.getUserById(userId);
        if (appUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Category category = categoryService.getCategoryById(categoryId);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listQuestions.setAppUser(appUser);
        listQuestions.setCategory(category);
        listQuestionsService.createListQuestions(listQuestions);
        return new ResponseEntity<>("List created successfully", HttpStatus.CREATED);
    }

    @GetMapping("get/{list_id}")
    public ResponseEntity<Object> getListQuestionsById(@PathVariable(value = "list_id") Long listId) {
        ListQuestions listQuestions = this.listQuestionsService.getListQuestionsById(listId);
        Hibernate.initialize(listQuestions.getCategory());
        List<ListQuestionsCommentDTO> comments = this.listQuestionsCommentMapper
                .listQuestionCommentsToListQuestionCommentDTOs(listQuestions.getListQuestionComment());
        ListQuestionsDTO listQuestionsDTO = this.listQuestionsMapper.listQuestionsToListQuestionsDTO(listQuestions);
        listQuestionsDTO.setComments(comments);
        return new ResponseEntity<>(listQuestionsDTO, HttpStatus.OK);
    }

    @GetMapping("get-with-questions/{list_id}")
    public ResponseEntity<Object> getListQuestionsWithQuestionsById(@PathVariable(value = "list_id") Long listId) {
        ListQuestions listQuestions = this.listQuestionsService.getListQuestionsById(listId);
        Hibernate.initialize(listQuestions.getCategory());
        ListQuestionsWithQuestionsDTO listQuestionsWithQuestionsDTO = this.listQuestionsMapper
                .listQuestionsToListQuestionsWithQuestionsDTO(listQuestions);
        List<ListQuestionsCommentDTO> comments = this.listQuestionsCommentMapper
                .listQuestionCommentsToListQuestionCommentDTOs(listQuestions.getListQuestionComment());
        listQuestionsWithQuestionsDTO.setComments(comments);
        return new ResponseEntity<>(listQuestionsWithQuestionsDTO, HttpStatus.OK);
    }

}
