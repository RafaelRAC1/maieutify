package com.rafael.maieutify.mapper.dto.list_questions;

import com.rafael.maieutify.mapper.dto.user.CreatorDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListQuestionsDetailedDTO extends ListQuestionsDTO {
    private CreatorDTO creator;
}
