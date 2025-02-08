package com.rafael.maieutify.mapper.dto.list_questions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ListQuestionsRatingDTO {
    private long ratings;
    private Float averageRating;
}
