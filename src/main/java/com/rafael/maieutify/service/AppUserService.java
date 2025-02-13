package com.rafael.maieutify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.maieutify.model.entity.AppUser;
import com.rafael.maieutify.repository.AppUserRepository;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser createUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public AppUser getUserById(Long id) {
        return appUserRepository.findById(id).orElse(null);
    }  

    public List<AppUser> createUsers(List<AppUser> appUsers) {
        return appUserRepository.saveAll(appUsers);
    }
}
