package com.rafael.maieutify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.maieutify.model.entity.ListQuestions;
import com.rafael.maieutify.model.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{
    List<Question> findQuestionsByListQuestions(ListQuestions listQuestions);
}
