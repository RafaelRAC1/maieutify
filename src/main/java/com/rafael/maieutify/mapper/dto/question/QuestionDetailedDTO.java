package com.rafael.maieutify.mapper.dto.question;

import java.util.List;

import com.rafael.maieutify.mapper.dto.alternative.AlternativeDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDetailedDTO extends QuestionDTO{
    private List<AlternativeDTO> alternatives;
}
