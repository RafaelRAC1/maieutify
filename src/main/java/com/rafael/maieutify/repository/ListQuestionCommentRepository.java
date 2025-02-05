package com.rafael.maieutify.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.maieutify.model.entity.ListQuestionComment;
import com.rafael.maieutify.model.entity.ListQuestions;

public interface ListQuestionCommentRepository extends JpaRepository<ListQuestionComment, Long> {
    Page<ListQuestionComment> findListQuestionsCommentByListQuestions(ListQuestions listQuestionsComment, Pageable pageable);
}
