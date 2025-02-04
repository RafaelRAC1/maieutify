package com.rafael.maieutify.repository;

import com.rafael.maieutify.model.entity.AppUser;
import com.rafael.maieutify.model.entity.Category;
import com.rafael.maieutify.model.entity.ListQuestions;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListQuestionsRepository extends JpaRepository<ListQuestions, Long> {
    List<ListQuestions> findByAppUser(AppUser appUser);

    Page<ListQuestions> findByCategory(Category category, Pageable pageable);

    Page<ListQuestions> findByTitleContaining(String title, Pageable pageable);
}
