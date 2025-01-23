package com.rafael.maieutify.repository;

import com.rafael.maieutify.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {}

