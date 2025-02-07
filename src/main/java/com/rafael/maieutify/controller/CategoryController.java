package com.rafael.maieutify.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.maieutify.mapper.CategoryMapper;
import com.rafael.maieutify.mapper.dto.category.CategoryDTO;
import com.rafael.maieutify.model.entity.Category;
import com.rafael.maieutify.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @PostMapping("/add")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return ResponseEntity.ok().body(categoryService.createCategory(category));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCategoryById(@RequestBody Long id){
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    @PostMapping("/addAll")
    public ResponseEntity<Object> createCategories(@RequestBody Iterable<Category> categories){
        categoryService.createCategories(categories);
        return new ResponseEntity<>("Categories created succesfully!", HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categories = this.categoryService.getAllCategories().stream().map(categoryMapper::categoryToCategoryDTO).collect(Collectors.toList());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
