package com.rafael.maieutify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.ListQuestionsUser;
import com.rafael.maieutify.repository.ListQuestionsUserRepository;

@Service
public class ListQuestionsUserService {
    @Autowired
    private ListQuestionsUserRepository listQuestionsUserRepository;

    public ListQuestionsUser createListQuestionsUser(ListQuestionsUser listQuestionsUser) {
        return listQuestionsUserRepository.save(listQuestionsUser);
    }

    public ListQuestionsUser getListQuestionUserById(Long id){
        return this.listQuestionsUserRepository.findById(id).orElse(null);
    }
}
