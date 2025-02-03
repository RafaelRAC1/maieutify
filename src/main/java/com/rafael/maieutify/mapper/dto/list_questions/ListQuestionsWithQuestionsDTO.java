package com.rafael.maieutify.mapper.dto.list_questions;

import java.util.List;

import com.rafael.maieutify.mapper.dto.question.QuestionDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListQuestionsWithQuestionsDTO extends ListQuestionsDTO{
    private List<QuestionDTO> questions;
}
