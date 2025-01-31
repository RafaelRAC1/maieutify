package com.rafael.maieutify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.maieutify.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
