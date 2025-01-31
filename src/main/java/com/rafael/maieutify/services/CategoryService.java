package com.rafael.maieutify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.Category;
import com.rafael.maieutify.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Iterable<Category> createCategories(Iterable<Category> categories){
        return categoryRepository.saveAll(categories);
    }
}
