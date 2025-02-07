package com.rafael.maieutify.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rafael.maieutify.mapper.dto.category.CategoryDTO;
import com.rafael.maieutify.model.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(source = "categoryName", target = "name")
    CategoryDTO categoryToCategoryDTO(Category category);
}
