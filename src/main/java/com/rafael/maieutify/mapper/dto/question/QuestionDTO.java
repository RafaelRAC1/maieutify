package com.rafael.maieutify.mapper.dto.question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {
    private int questionNumber;
    private String statement;
    private String hint;
}
