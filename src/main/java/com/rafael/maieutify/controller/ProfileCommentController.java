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
import com.rafael.maieutify.model.entity.ProfileComment;
import com.rafael.maieutify.service.AppUserService;
import com.rafael.maieutify.service.ProfileCommentService;

@RestController
@RequestMapping("/profile-comment")
public class ProfileCommentController {
    @Autowired
    private ProfileCommentService profileCommentService;

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/add/profile/{profile_id}/commenter/{user_id}")
    public ResponseEntity<Object> createProfileComment(@PathVariable(value = "profile_id") Long profileId, @PathVariable(value = "user_id") Long userId, @RequestBody ProfileComment profileComment){
        AppUser profile = appUserService.getUserById(profileId);
        AppUser commenter = appUserService.getUserById(userId);
        if(profile == null || commenter == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }   
        profileComment.setProfile(profile);
        profileComment.setCommenter(commenter);
        profileCommentService.createProfileComment(profileComment);
        return new ResponseEntity<>("Profile comment created successfully", HttpStatus.CREATED);
    }
}
