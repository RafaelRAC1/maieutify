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

import com.rafael.maieutify.mapper.ProfileCommentMapper;
import com.rafael.maieutify.mapper.dto.profile_comment.ProfileCommentDTO;
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
    private ProfileCommentMapper profileCommentMapper;

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/add/profile/{profile_id}/commenter/{user_id}")
    public ResponseEntity<Object> createProfileComment(@PathVariable(value = "profile_id") Long profileId,
            @PathVariable(value = "user_id") Long userId, @RequestBody ProfileComment profileComment) {
        AppUser profile = appUserService.getUserById(profileId);
        AppUser commenter = appUserService.getUserById(userId);
        if (profile == null || commenter == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        profileComment.setProfile(profile);
        profileComment.setCommenter(commenter);
        profileCommentService.createProfileComment(profileComment);
        return new ResponseEntity<>("Profile comment created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{comment_id}")
    public ResponseEntity<ProfileCommentDTO> getProfileCommentById(@PathVariable(value = "comment_id") Long commentId) {
        ProfileComment profileComment = this.profileCommentService.getProfileCommentById(commentId);
        ProfileCommentDTO profileCommentDTO = this.profileCommentMapper
                .profileCommentToProfileCommentDTO(profileComment);
        return new ResponseEntity<>(profileCommentDTO, HttpStatus.OK);
    }

    @GetMapping("/get/profile/{profile_id}")
    public ResponseEntity<List<ProfileCommentDTO>> getProfileCommentByProfileId(
            @PathVariable(value = "profile_id") Long id,
            @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        Page<ProfileComment> profileComment = this.profileCommentService.getProfileCommentByProfileId(appUserService.getUserById(id), pageNo, pageSize);
        List<ProfileCommentDTO> profileCommentDTO = profileComment.stream().map(profileCommentMapper::profileCommentToProfileCommentDTO).collect(Collectors.toList());
        return new ResponseEntity<>(profileCommentDTO, HttpStatus.OK);
    }

    @GetMapping("/get/commenter/{commenter_id}")
    public ResponseEntity<List<ProfileCommentDTO>> getProfileCommentByCommenterId(
            @PathVariable(value = "commenter_id") Long id,
            @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        Page<ProfileComment> profileComment = this.profileCommentService.getProfileCommentByCommenterId(appUserService.getUserById(id), pageNo, pageSize);
        List<ProfileCommentDTO> profileCommentDTO = profileComment.stream().map(profileCommentMapper::profileCommentToProfileCommentDTO).collect(Collectors.toList());
        return new ResponseEntity<>(profileCommentDTO, HttpStatus.OK);
    }
}
