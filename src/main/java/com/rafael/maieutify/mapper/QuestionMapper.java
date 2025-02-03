package com.rafael.maieutify.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.rafael.maieutify.mapper.dto.question.QuestionDTO;
import com.rafael.maieutify.model.entity.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    List<QuestionDTO> questionsToQuestionsDTO(List<Question> questions);
}
