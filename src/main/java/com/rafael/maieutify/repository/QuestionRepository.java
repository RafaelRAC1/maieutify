package com.rafael.maieutify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.maieutify.model.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{}
