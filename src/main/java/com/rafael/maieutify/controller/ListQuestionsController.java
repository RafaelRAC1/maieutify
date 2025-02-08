package com.rafael.maieutify.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.maieutify.mapper.ListQuestionsMapper;
import com.rafael.maieutify.mapper.dto.list_questions.ListQuestionsDTO;
import com.rafael.maieutify.mapper.dto.list_questions.ListQuestionsDetailedDTO;
import com.rafael.maieutify.mapper.dto.list_questions.ListQuestionsRatingDTO;
import com.rafael.maieutify.mapper.dto.list_questions.ListQuestionsWithQuestionsDTO;
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
        ListQuestionsDetailedDTO listQuestionsDetailedDTO = this.listQuestionsMapper
                .listQuestionsToListQuestionsDetailedDTO(listQuestions);
        return new ResponseEntity<>(listQuestionsDetailedDTO, HttpStatus.OK);
    }

    @GetMapping("get-with-questions/{list_id}")
    public ResponseEntity<Object> getListQuestionsWithQuestionsById(@PathVariable(value = "list_id") Long listId) {
        ListQuestions listQuestions = this.listQuestionsService.getListQuestionsById(listId);
        Hibernate.initialize(listQuestions.getCategory());
        ListQuestionsWithQuestionsDTO listQuestionsWithQuestionsDTO = this.listQuestionsMapper
                .listQuestionsToListQuestionsWithQuestionsDTO(listQuestions);
        return new ResponseEntity<>(listQuestionsWithQuestionsDTO, HttpStatus.OK);
    }

    @GetMapping("get/user/{user_id}")
    public ResponseEntity<List<ListQuestionsDTO>> getListQuestionsByUserId(
            @PathVariable(value = "user_id") Long userId) {
        List<ListQuestions> listQuestions = this.listQuestionsService
                .getListsQuestionsByUserId(this.appUserService.getUserById(userId));
        List<ListQuestionsDTO> listQuestionsDTO = this.listQuestionsMapper
                .listsQuestionsToListsQuestionsDTO(listQuestions);
        return new ResponseEntity<>(listQuestionsDTO, HttpStatus.OK);
    }

    @GetMapping("get/category/{category_id}")
    public ResponseEntity<List<ListQuestionsDetailedDTO>> getListQuestionsByCategoryId(
            @PathVariable(value = "category_id") Long categoryId, @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<ListQuestions> listQuestions = this.listQuestionsService
                .getListsQuestionsByCategoryId(this.categoryService.getCategoryById(categoryId), pageNo, pageSize);

        List<ListQuestionsDetailedDTO> listQuestionsDetailedDTOList = listQuestions.stream()
                .map(listQuestionsMapper::listQuestionsToListQuestionsDetailedDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(listQuestionsDetailedDTOList, HttpStatus.OK);
    }

    @GetMapping("get/title")
    public ResponseEntity<List<ListQuestionsDetailedDTO>> getListByTitle(
            @RequestParam(name = "name", required = true) String name, @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<ListQuestions> listQuestions = this.listQuestionsService.getListsQuestionsByTitle(name, pageNo, pageSize);
        List<ListQuestionsDetailedDTO> listQuestionsDetailedDTO = listQuestions.stream()
                .map(listQuestionsMapper::listQuestionsToListQuestionsDetailedDTO).collect(Collectors.toList());
        return new ResponseEntity<>(listQuestionsDetailedDTO, HttpStatus.OK);
    }

    @GetMapping("get-rating/{list_id}")
    public ResponseEntity<Optional<ListQuestionsRatingDTO>> getListRatingByListId(@PathVariable(value = "list_id") Long listId) {
        Optional<ListQuestionsRatingDTO> listQuestionsRatingDTO = this.listQuestionsService.getListQuestionsRating(listId);
        return new ResponseEntity<>(listQuestionsRatingDTO, HttpStatus.OK);
    }
}
