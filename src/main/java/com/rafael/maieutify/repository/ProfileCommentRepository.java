package com.rafael.maieutify.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.maieutify.model.entity.AppUser;
import com.rafael.maieutify.model.entity.ProfileComment;

public interface ProfileCommentRepository extends JpaRepository<ProfileComment, Long> {
    Page<ProfileComment> findByProfile(AppUser profile, Pageable pageable);

    Page<ProfileComment> findByCommenter(AppUser commenter, Pageable pageable);
}
