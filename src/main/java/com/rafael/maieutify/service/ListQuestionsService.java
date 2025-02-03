package com.rafael.maieutify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.ListQuestions;
import com.rafael.maieutify.repository.ListQuestionsRepository;

@Service
public class ListQuestionsService {
    @Autowired
    private ListQuestionsRepository listQuestionsRepository;

    public ListQuestions createListQuestions(ListQuestions listQuestions) {
        return listQuestionsRepository.save(listQuestions);
    }

    public ListQuestions getListQuestionsById(Long id) {
        return listQuestionsRepository.findById(id).orElse(null);
    }
}
