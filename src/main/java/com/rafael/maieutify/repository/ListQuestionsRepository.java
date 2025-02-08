package com.rafael.maieutify.repository;

import com.rafael.maieutify.mapper.dto.list_questions.ListQuestionsRatingDTO;
import com.rafael.maieutify.model.entity.AppUser;
import com.rafael.maieutify.model.entity.Category;
import com.rafael.maieutify.model.entity.ListQuestions;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListQuestionsRepository extends JpaRepository<ListQuestions, Long> {
    List<ListQuestions> findByAppUser(AppUser appUser);

    Page<ListQuestions> findByCategory(Category category, Pageable pageable);

    Page<ListQuestions> findByTitleContaining(String title, Pageable pageable);

    @Query(
            nativeQuery = true,
            value =
            "SELECT COUNT(l.list_id), ROUND(AVG(l.rating), 2) " +
           "FROM list_questions__user l " +
           "WHERE l.list_id = :listId")
    Optional<ListQuestionsRatingDTO> findListRatingByListId(Long listId);
}
