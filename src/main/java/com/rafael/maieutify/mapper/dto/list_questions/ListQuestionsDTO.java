package com.rafael.maieutify.mapper.dto.list_questions;

import java.util.Date;
import java.util.List;

import com.rafael.maieutify.mapper.dto.list_questions_comments.ListQuestionsCommentDTO;
import com.rafael.maieutify.mapper.dto.user.CreatorDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListQuestionsDTO {
    private String title;
    private String listDescription;
    private Float difficulty;
    private Date lastUpdated;
    private String listImage;
    private String categoryName;
    private CreatorDTO creator;
    private List<ListQuestionsCommentDTO> comments;
}
