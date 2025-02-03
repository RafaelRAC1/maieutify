package com.rafael.maieutify.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rafael.maieutify.mapper.dto.list_questions.ListQuestionsDTO;
import com.rafael.maieutify.mapper.dto.list_questions.ListQuestionsWithQuestionsDTO;
import com.rafael.maieutify.model.entity.ListQuestions;

@Mapper(componentModel = "spring")
public interface ListQuestionsMapper {
    @Mapping(source = "category.categoryName", target = "categoryName")
    @Mapping(source = "appUser", target = "creator")
    @Mapping(source = "listQuestionComment", target = "comments")
    ListQuestionsDTO listQuestionsToListQuestionsDTO(ListQuestions listQuestions);

    @Mapping(source = "question", target = "questions")
    @Mapping(source = "category.categoryName", target = "categoryName")
    @Mapping(source = "appUser", target = "creator")
    ListQuestionsWithQuestionsDTO listQuestionsToListQuestionsWithQuestionsDTO(ListQuestions listQuestions);
}
