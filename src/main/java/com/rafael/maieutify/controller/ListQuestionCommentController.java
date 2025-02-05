package com.rafael.maieutify.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.rafael.maieutify.mapper.ListQuestionsCommentMapper;
import com.rafael.maieutify.mapper.dto.list_questions_comments.ListQuestionsCommentDTO;
import com.rafael.maieutify.model.entity.AppUser;
import com.rafael.maieutify.model.entity.ListQuestionComment;
import com.rafael.maieutify.model.entity.ListQuestions;
import com.rafael.maieutify.service.AppUserService;
import com.rafael.maieutify.service.ListQuestionCommentService;
import com.rafael.maieutify.service.ListQuestionsService;

@RestController
@RequestMapping("/list-comment")
public class ListQuestionCommentController {
    @Autowired
    private ListQuestionCommentService listQuestionCommentService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ListQuestionsService listQuestionsService;

    @Autowired
    private ListQuestionsCommentMapper listQuestionsCommentMapper;

    @PostMapping("/add/list/{list_id}/commenter/{user_id}")
    public ResponseEntity<Object> createListQuestionComment(@PathVariable(value = "list_id") long listId,
            @PathVariable(value = "user_id") long userId, @RequestBody ListQuestionComment listQuestionComment) {
        AppUser commenter = appUserService.getUserById(userId);
        if (commenter == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ListQuestions listQuestions = listQuestionsService.getListQuestionsById(listId);
        if (listQuestions == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listQuestionComment.setAppUser(commenter);
        listQuestionComment.setListQuestions(listQuestions);
        listQuestionCommentService.createListQuestionComment(listQuestionComment);
        return new ResponseEntity<>("Comment created successfully", HttpStatus.CREATED);
    }

    // @GetMapping("/get/{comment_id}")

    @GetMapping("/get/list/{list_id}")
    public ResponseEntity<List<ListQuestionsCommentDTO>> getListQuestionCommentsByListId(
            @PathVariable(value = "list_id") Long listId, @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<ListQuestionComment> listQuestionComment = this.listQuestionCommentService
                .getListQuestionCommentByListQuestionId(this.listQuestionsService.getListQuestionsById(listId), pageNo,
                        pageSize);
        List<ListQuestionsCommentDTO> listQuestionsCommentDTO = listQuestionComment.stream()
                .map(this.listQuestionsCommentMapper::listQuestionCommentToListQuestionCommentDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(listQuestionsCommentDTO, HttpStatus.OK);
    }

}
