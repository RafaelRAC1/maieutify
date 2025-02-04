package com.rafael.maieutify.mapper.dto.profile_comment;

import java.util.Date;

import com.rafael.maieutify.mapper.dto.user.CreatorDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileCommentDTO {
    private CreatorDTO commenter;
    private String comment;
    private Date lastUpdated;
    private boolean edited;
}   
