package com.rafael.maieutify.mapper.dto.user;

import java.util.List;

import com.rafael.maieutify.mapper.dto.profile_comment.ProfileCommentDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserWithCommentsDTO extends AppUserDTO {
    private List<ProfileCommentDTO> profileCommentList;
}
