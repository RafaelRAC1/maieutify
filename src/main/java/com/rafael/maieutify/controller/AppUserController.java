package com.rafael.maieutify.controller;

import com.rafael.maieutify.model.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.maieutify.services.AppUserService;;

@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/add")
    public AppUser createUser(@RequestBody AppUser appUser) {
        return appUserService.createUser(appUser);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable(value = "id") long userId) throws Exception{
        AppUser appUser = appUserService.getUserById(userId);
        return ResponseEntity.ok().body(appUser);
    }
}
