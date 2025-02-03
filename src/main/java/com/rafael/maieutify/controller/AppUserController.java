package com.rafael.maieutify.controller;

import com.rafael.maieutify.mapper.AppUserMapper;
import com.rafael.maieutify.mapper.dto.user.AppUserDTO;
import com.rafael.maieutify.model.entity.AppUser;
import com.rafael.maieutify.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;;

@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserMapper appUserMapper;

    @PostMapping("/add")
    public AppUser createUser(@RequestBody AppUser appUser) {
        return appUserService.createUser(appUser);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AppUserDTO> getUserById(@PathVariable(value = "id") long userId) throws Exception{
        AppUser appUser = appUserService.getUserById(userId);
        AppUserDTO appUserDTO = this.appUserMapper.appUserToAppUserDTO(appUser);
        return new ResponseEntity<>(appUserDTO, HttpStatus.OK);
    }
}
