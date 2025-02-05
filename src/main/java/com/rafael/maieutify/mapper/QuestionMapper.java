package com.rafael.maieutify.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rafael.maieutify.mapper.dto.question.QuestionDTO;
import com.rafael.maieutify.mapper.dto.question.QuestionDetailedDTO;
import com.rafael.maieutify.model.entity.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    List<QuestionDTO> questionsToQuestionsDTO(List<Question> questions);

    QuestionDTO questionToQuestionDTO(Question question);

    @Mapping(source = "alternative", target = "alternatives")
    QuestionDetailedDTO questionToQuestionDetailedDTO(Question question);
}
