package com.rafael.maieutify.mapper.dto.user;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserDTO {
    private String displayName;
    private String pfp;
    private Date registrationDate;
    private String tags;
    private String bio;
}
