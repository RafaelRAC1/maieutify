package com.rafael.maieutify.mapper.dto.list_questions;

import java.util.Date;

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
}
