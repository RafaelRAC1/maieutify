package com.rafael.maieutify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.maieutify.model.entity.ListQuestionsUser;
import com.rafael.maieutify.model.entity.UserAnswer;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    List<UserAnswer> findUserAnswerByListQuestionsUser(ListQuestionsUser listQuestionsUser);
}
