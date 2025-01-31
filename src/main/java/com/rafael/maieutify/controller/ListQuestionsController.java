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
import com.rafael.maieutify.model.entity.Category;
import com.rafael.maieutify.model.entity.ListQuestions;
import com.rafael.maieutify.services.AppUserService;
import com.rafael.maieutify.services.CategoryService;
import com.rafael.maieutify.services.ListQuestionsService;

@RestController
@RequestMapping("list")
public class ListQuestionsController {
    @Autowired
    private ListQuestionsService listQuestionsService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private CategoryService categoryService;

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
}
