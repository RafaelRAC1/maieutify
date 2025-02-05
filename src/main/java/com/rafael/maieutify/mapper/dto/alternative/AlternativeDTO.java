package com.rafael.maieutify.mapper.dto.alternative;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlternativeDTO {
    private char alternativeCharacter;
    private String alternativeDescription;
    private Boolean correct;
}
