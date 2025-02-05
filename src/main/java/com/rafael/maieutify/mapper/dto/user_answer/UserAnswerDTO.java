package com.rafael.maieutify.mapper.dto.user_answer;

import com.rafael.maieutify.mapper.dto.alternative.AlternativeDTO;
import com.rafael.maieutify.mapper.dto.question.QuestionDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAnswerDTO {
    private QuestionDTO question;
    private AlternativeDTO alternative;
}
