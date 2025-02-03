package com.rafael.maieutify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.ListQuestionComment;
import com.rafael.maieutify.repository.ListQuestionCommentRepository;

@Service
public class ListQuestionCommentService  {
    @Autowired
    private ListQuestionCommentRepository listQuestionCommentRepository;

    public ListQuestionComment createListQuestionComment(ListQuestionComment listQuestionComment) {
        return listQuestionCommentRepository.save(listQuestionComment);
    }

    public ListQuestionComment getListQuestionsById(Long id) {
        return listQuestionCommentRepository.findById(id).orElse(null);
    }
}
