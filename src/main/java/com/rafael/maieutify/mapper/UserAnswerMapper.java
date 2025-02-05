package com.rafael.maieutify.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rafael.maieutify.mapper.dto.user_answer.UserAnswerDTO;
import com.rafael.maieutify.model.entity.UserAnswer;

@Mapper(componentModel = "spring")
public interface UserAnswerMapper {
    @Mapping(source = "question", target = "question")
    @Mapping(source = "alternative", target = "alternative")
    UserAnswerDTO userAnswerToUserAnswerDTO(UserAnswer userAnswer);
}
