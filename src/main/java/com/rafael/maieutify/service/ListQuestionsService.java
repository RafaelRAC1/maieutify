package com.rafael.maieutify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.AppUser;
import com.rafael.maieutify.model.entity.Category;
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

    public List<ListQuestions> getListsQuestionsByUserId(AppUser appUser){
        return listQuestionsRepository.findByAppUser(appUser);
    }

    public Page<ListQuestions> getListsQuestionsByCategoryId(Category category, int pageNo, int pageSize){
        PageRequest pageable = PageRequest.of(pageNo, pageSize);
        return this.listQuestionsRepository.findByCategory(category, pageable);
    }

    public Page<ListQuestions> getListsQuestionsByTitle(String title, int pageNo, int pageSize){
        PageRequest pageable = PageRequest.of(pageNo, pageSize);
        return this.listQuestionsRepository.findByTitleContaining(title, pageable);
    }
}
