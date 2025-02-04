package com.rafael.maieutify.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rafael.maieutify.mapper.dto.profile_comment.ProfileCommentDTO;
import com.rafael.maieutify.model.entity.ProfileComment;

@Mapper(componentModel = "spring")
public interface ProfileCommentMapper {
    @Mapping(source = "commenter", target = "commenter")
    ProfileCommentDTO profileCommentToProfileCommentDTO(ProfileComment profileComment);
}
