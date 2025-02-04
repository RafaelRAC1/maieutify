package com.rafael.maieutify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.AppUser;
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

        public Page<ProfileComment> getProfileCommentByProfileId(AppUser appUser, int pageNo, int pageSize){
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return this.profileCommentRepository.findByProfile(appUser, pageable);
        }

        public Page<ProfileComment> getProfileCommentByCommenterId(AppUser appUser, int pageNo, int pageSize){
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return this.profileCommentRepository.findByCommenter(appUser, pageable);
        }
}   
