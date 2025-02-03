package com.rafael.maieutify.mapper.dto.list_questions_comments;

import java.util.Date;

import com.rafael.maieutify.mapper.dto.user.CreatorDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListQuestionsCommentDTO {
    private CreatorDTO creator;
    private String comment;
    private Date lastUpdated;
    private Boolean edited;
}
