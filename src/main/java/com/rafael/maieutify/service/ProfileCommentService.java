package com.rafael.maieutify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.ProfileComment;
import com.rafael.maieutify.repository.ProfileCommentRepository;

@Service
public class ProfileCommentService {
        @Autowired
        private ProfileCommentRepository profileCommentRepository;
        
        public ProfileComment createProfileComment(ProfileComment profileComment) {
            return profileCommentRepository.save(profileComment);
        }

        public ProfileComment getProfileCommentById(Long id) {
            return profileCommentRepository.findById(id).orElse(null);
        }
}   
