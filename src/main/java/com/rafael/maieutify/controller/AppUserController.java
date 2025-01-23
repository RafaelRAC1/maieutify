package com.rafael.maieutify.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.rafael.maieutify.model.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.maieutify.repository.AppUserRepository;;

@RestController
@RequestMapping("/api/v1")
public class AppUserController {
    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping("/users")
    public AppUser createUser(@RequestBody AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable(value = "id") Long userId) throws Exception{
        AppUser appUser = appUserRepository.findById(userId).orElseThrow(() -> new Exception("Dis is a lil bad"));
        return ResponseEntity.ok().body(appUser);
    }
}
