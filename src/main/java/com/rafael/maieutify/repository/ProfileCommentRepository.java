package com.rafael.maieutify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.maieutify.model.entity.ProfileComment;

public interface ProfileCommentRepository extends JpaRepository<ProfileComment, Long> {}
