package com.rafael.maieutify.mapper;

import org.mapstruct.Mapper;

import com.rafael.maieutify.mapper.dto.alternative.AlternativeDTO;
import com.rafael.maieutify.model.entity.Alternative;

@Mapper(componentModel = "spring")
public interface AlternativeMapper {
    AlternativeDTO alternativeToAlternativeDTO(Alternative alternative);
}
