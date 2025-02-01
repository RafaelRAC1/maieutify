package com.rafael.maieutify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.maieutify.model.entity.UserAnswer;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {}
