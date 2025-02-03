package com.rafael.maieutify.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rafael.maieutify.mapper.dto.list_questions_comments.ListQuestionsCommentDTO;
import com.rafael.maieutify.model.entity.ListQuestionComment;

@Mapper(componentModel = "spring")
public interface ListQuestionsCommentMapper {
    @Mapping(source = "appUser", target = "creator")
    ListQuestionsCommentDTO listQuestionCommentToListQuestionCommentDTO(ListQuestionComment ListQuestionsComment);

    default List<ListQuestionsCommentDTO> listQuestionCommentsToListQuestionCommentDTOs(List<ListQuestionComment> comments) {
        List<ListQuestionsCommentDTO> dtoList = new ArrayList<>();
        for (ListQuestionComment comment : comments) {
            dtoList.add(listQuestionCommentToListQuestionCommentDTO(comment));
        }
        return dtoList;
    }
}
