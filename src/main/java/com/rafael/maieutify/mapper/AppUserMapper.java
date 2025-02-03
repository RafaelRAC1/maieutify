package com.rafael.maieutify.mapper;

import org.mapstruct.Mapper;

import com.rafael.maieutify.mapper.dto.user.AppUserDTO;
import com.rafael.maieutify.mapper.dto.user.CreatorDTO;
import com.rafael.maieutify.model.entity.AppUser;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUserDTO appUserToAppUserDTO(AppUser appUser);
    CreatorDTO appUserToCreatorDTO(AppUser appUser);
}
 